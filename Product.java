import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    @JsonProperty("product_name")
    private String product_name;

    @JsonProperty("product_code")
    private int product_code;

    @JsonProperty("price")
    private double price;

    @JsonProperty("description")
    private String description;

    public Product() {}

    public Product(String product_name, int product_code, double price, String description) {
        this.product_name = product_name;
        this.product_code = product_code;
        this.price = price;
        this.description = description;
    }

    public int getProductCode() {
        return product_code;
    }

    public void setProductCode(int product_code) {
        this.product_code = product_code;
    }

    public String getProductName() {
        return product_name;
    }

    public void setProductName(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
