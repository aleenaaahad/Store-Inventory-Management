import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Frame2 extends Frame {
    // The button and text fields/area are now all class variables, so that other methods can access them.
    Button printReceiptButton;
    TextArea itemsTextArea;
    TextField totalBeforeField;
    TextField totalWithTaxField;
    TextField discountAppliedField;
    TextField grandTotalField;

    protected JsonToObject jsonToObject;

    public Frame2(JsonToObject jsonToObject) {
        this.jsonToObject = jsonToObject;

        setLayout(new GridLayout(2, 1));

        add(createItemsPanel());
        add(createSummaryPanel());

        setTitle("Invoice");
        setSize(600, 600);
        setVisible(true);

        // Stops program when closing Frame
        addWindowListener(new WindowAdapter() {
            // Window closing method
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private Panel createItemsPanel() {
        Panel itemsPanel = new Panel(new BorderLayout());

        itemsPanel.add(new Label("Items and Quantities"), BorderLayout.NORTH);
        itemsTextArea = new TextArea();
        itemsPanel.add(itemsTextArea, BorderLayout.CENTER);

        return itemsPanel;
    }

    private Panel createSummaryPanel() {
        Panel summaryPanel = new Panel(new GridLayout(2, 1));

        // Sub-panel for tax, discount, and totals
        Panel taxDiscountPanel = new Panel(new GridLayout(5, 2));
        taxDiscountPanel.add(new Label("Sales Tax (%):"));
        TextField salesTaxField = new TextField("9.38");
        taxDiscountPanel.add(salesTaxField);

        taxDiscountPanel.add(new Label("City and State:"));
        TextField cityStateField = new TextField("San Jose, California");
        taxDiscountPanel.add(cityStateField);

        taxDiscountPanel.add(new Label("Discount (%):"));
        TextField discountField = new TextField("5");
        taxDiscountPanel.add(discountField);

        Checkbox discountCheckbox = new Checkbox("Apply Discount");
        taxDiscountPanel.add(discountCheckbox);
        taxDiscountPanel.add(new Label(""));

        taxDiscountPanel.add(new Label("Total Before Tax/Discount:"));
        totalBeforeField = new TextField("0.00");
        totalBeforeField.setEditable(false);
        taxDiscountPanel.add(totalBeforeField);

        taxDiscountPanel.add(new Label("Total with Tax:"));
        totalWithTaxField = new TextField("0.00");
        totalWithTaxField.setEditable(false);
        taxDiscountPanel.add(totalWithTaxField);

        taxDiscountPanel.add(new Label("Discount Applied:"));
        discountAppliedField = new TextField("0.00");
        discountAppliedField.setEditable(false);
        taxDiscountPanel.add(discountAppliedField);

        taxDiscountPanel.add(new Label("Grand Total:"));
        grandTotalField = new TextField("0.00");
        grandTotalField.setEditable(false);
        taxDiscountPanel.add(grandTotalField);

        summaryPanel.add(taxDiscountPanel);

        // Sub-panel for Print Receipt button
        Panel buttonPanel = new Panel();
        // I made the button into a class variable
        printReceiptButton = new Button("Print Receipt");
        buttonPanel.add(printReceiptButton);
        summaryPanel.add(buttonPanel);

        // Receipt Frame Logic
        printReceiptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame receiptFrame = new Frame("Receipt");
                receiptFrame.setSize(400, 500);
                receiptFrame.setLayout(new BorderLayout());

                TextArea receiptArea = new TextArea();
                receiptArea.setEditable(false);

                // Create the receipt content
                StringBuilder receiptContent = new StringBuilder();
                receiptContent.append("Hello Kitty Stationary Shop\n");
                receiptContent.append("San Jose, California\n");
                receiptContent.append("Phone: 123-456-7890\n");
                receiptContent.append("Date: " + new Date() + "\n\n");

                receiptContent.append("Items:\n");
                receiptContent.append(itemsTextArea.getText()).append("\n\n");

                receiptContent.append("Total Before Tax/Discount: " + totalBeforeField.getText() + "\n");
                receiptContent.append("Total with Tax: " + totalWithTaxField.getText() + "\n");
                receiptContent.append("Discount Applied: " + discountAppliedField.getText() + "\n");
                receiptContent.append("Grand Total: " + grandTotalField.getText() + "\n\n");

                receiptContent.append("Thank you for shopping with us!\n");

                receiptArea.setText(receiptContent.toString());
                receiptFrame.add(receiptArea, BorderLayout.CENTER);

                receiptFrame.setVisible(true);

                /* A window listener for the receipt frames that close the windows and without stopping the program
                 * and release the utilized system resources */
                receiptFrame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        // Release resources used by selected receiptFrame
                        receiptFrame.dispose();
                    }
                });
            }
        });

        return summaryPanel;
    }
}