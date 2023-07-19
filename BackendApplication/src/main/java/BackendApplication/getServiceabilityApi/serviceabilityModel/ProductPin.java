package BackendApplication.getServiceabilityApi.serviceabilityModel;

public class ProductPin {
    private Integer userPin;

    public ProductPin(Integer userPin) {
        this.userPin = userPin;
    }
    public ProductPin() {

    }

    public Integer getUserPin() {
        return userPin;
    }

    public void setUserPin(Integer userPin) {
        this.userPin = userPin;
    }

    @Override
    public String toString() {
        return "ProductPin{" +
                "userPin=" + userPin +
                '}';
    }
}
