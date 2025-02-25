public class Main {
    public static void main(String[] args){
        /* Object that stores the JSON data in corresponding Product and StoreInfo objects with a method to parse file.
        *
        *This object is in the main where the other frame classes get called so that it can be passed to both objects.
        * They will share the same reference to jsonToObject, since that object stores the JSON information as objects */
        JsonToObject jsonToObject = new JsonToObject();

        // jsonToObject is passed through the constructor, so that both frame classes can access the data of the object
        Frame1 frame1 = new Frame1(jsonToObject);
        Frame2 frame2 = new Frame2(jsonToObject);

        /* Instantiation for JsonToObject now under the action listener for loadInventoryButton
        * Currently show list is not working as intended, but for now the information is printed to the console
         */

    }
}