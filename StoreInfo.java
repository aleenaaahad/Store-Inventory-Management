import com.fasterxml.jackson.annotation.JsonProperty;

public class StoreInfo {
    @JsonProperty("store_name")
    private String store_name;

    @JsonProperty("phone_number")
    private String phone_number;

    @JsonProperty("state")
    private String state;

    @JsonProperty("city")
    private String city;

    @JsonProperty("tax_percentage")
    private double tax_percentage;

    // Jackson requires this constructor
    public StoreInfo() {}

    public StoreInfo(String store_name, String phone_number, String state, String city, double tax_percentage) {
        this.store_name = store_name;
        this.phone_number = phone_number;
        this.state = state;
        this.city = city;
        this.tax_percentage = tax_percentage;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_name() {
        return store_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTax_percentage() {
        return tax_percentage;
    }

    public void setTax_percentage(double tax_percentage) {
        this.tax_percentage = tax_percentage;
    }
}
