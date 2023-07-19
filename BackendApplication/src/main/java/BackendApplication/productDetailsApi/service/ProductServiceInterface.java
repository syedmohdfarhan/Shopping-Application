package BackendApplication.productDetailsApi.service;

import BackendApplication.exceptionHandler.ProductNotFoundException;
import BackendApplication.productDetailsApi.model.Product;

import java.util.List;

public interface ProductServiceInterface {
    public Boolean addProduct(Product product);
    public Product getProductByProductCode(int productId) throws ProductNotFoundException;
    public List<Product> getProductByName(String productName) throws ProductNotFoundException;
    public List<Product> getAllProducts();

    public List<Product> getProductByBrand(String productBrand) throws ProductNotFoundException;
    public List<Product> getProductByPrice(int productPrice);
}
