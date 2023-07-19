package BackendApplication.productDetailsApi.service;

import BackendApplication.exceptionHandler.ProductNotFoundException;
import BackendApplication.productDetailsApi.model.Product;
import BackendApplication.productDetailsApi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductServiceInterface{
    @Autowired
    ProductRepository productRepository;


    //product was added in db
    @Override
    public Boolean addProduct(Product product) {
        if(this.productRepository.existsById(product.getId())) {
            return false;
        }
        else {
            productRepository.save(product);
            return true;
        }
    }
    @Override
    public Product getProductByProductCode(int productId) throws ProductNotFoundException{
        if (this.productRepository.existsById(productId)) {
            Product getProductByProductCode=this.productRepository.findById(productId).get();
            return getProductByProductCode;
        }
        else {
            throw new ProductNotFoundException("Sorry this product is unavailable");
            //return null;
        }
    }

    @Override
    public List<Product> getProductByName(String productName) throws ProductNotFoundException{
        List<Product> allProductsByName=
                this.productRepository.getProductsByName(productName);
        if(allProductsByName.size()==0) {
            throw new ProductNotFoundException("Sorry this product is unavailable");
          // return null;
        }
        else {
            return allProductsByName;
        }
    }

    @Override
    public List<Product> getProductByBrand(String productBrand) throws ProductNotFoundException{
        List<Product> allProductsByName=
                this.productRepository.getProductsByBrand(productBrand);
        if(allProductsByName.size()==0) {
            throw new ProductNotFoundException("Sorry this product is unavailable");
            //return null;
        }
        else {
            return allProductsByName;
        }
    }


    @Override
    public List<Product> getProductByPrice(int productPrice) {
        List<Product> allProductsByPrice=
                this.productRepository.getProductsByPrice(productPrice);
        if(allProductsByPrice.size()==0) {

            return null;
        }
        else {
            return allProductsByPrice;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
