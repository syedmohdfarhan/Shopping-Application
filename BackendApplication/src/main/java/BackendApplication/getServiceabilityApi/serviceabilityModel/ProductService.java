package BackendApplication.getServiceabilityApi.serviceabilityModel;

import javax.persistence.*;

@Entity
@Table(name="ProductService")
public class ProductService{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int serviceId;
    private int pinCode;




    public ProductService() {
    }

    public ProductService(int serviceId , int pinCode, int noOfDays) {
        this.serviceId = serviceId;
        this.pinCode = pinCode;

    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }



    @Override
    public String toString() {
        return "ProductService{" +
                "serviceId=" + serviceId +
                ", pinCode=" + pinCode +


                '}';
    }
}
