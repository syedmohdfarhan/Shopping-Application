package BackendApplication.productDetailsApi.model;

import BackendApplication.getServiceabilityApi.serviceabilityModel.ProductService;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="ProductData")
public class Product {
    @Id
    private Integer id;
    private String name;
    private String description;
    private String brand;
    private Integer price;
    private String image;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Set<ProductService> product_pin=new HashSet<>();

    public Product() {
    }

    public Product(Integer id, String name, String description, String brand, Integer price, String image, String isDelivered, Set<ProductService> product_pin) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.image = image;

        this.product_pin = product_pin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public Set<ProductService> getProduct_pin() {
        return product_pin;
    }

    public void setProduct_pin(Set<ProductService> product_pin) {
        this.product_pin = product_pin;
    }
}