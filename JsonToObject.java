import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class JsonToObject {
    public List<Product> listOfProducts;
    public StoreInfo storeInfo;

    public JsonToObject() {
        System.out.println("JsonToObject has been instantiated");
    }

    public void parseJson() {
        try {
            // Create ObjectMapper to read and write the data from a JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Load JSON file from resources folder
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("Json.json");
            if (inputStream == null) {
                throw new IllegalArgumentException("Where did Jason go?!");
            }

            // Reads the file to convert it into a map of string keys and object values
            Map<String, Object> data = objectMapper.readValue(inputStream, new TypeReference<Map<String, Object>>() {});

            // Extracts the store_info section of the JSON into a StoreInfo object
            storeInfo = objectMapper.convertValue(data.get("store_info"), StoreInfo.class);

            // Extracts the product_info section of the JSON into an arraylist of Product objects
            listOfProducts = objectMapper.convertValue(data.get("product_info"), new TypeReference<List<Product>>() {});

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
