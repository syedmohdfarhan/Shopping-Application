package BackendApplication.productDetailsApi.repository;

import BackendApplication.productDetailsApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//jpa repository consists of methods like save/delete/existsbyid
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
   // List<Product> findAll(String productName);
    //@Query("select p From product_data p" )

    public List<Product> getProductsByName(String productName);
   // List<Product> getProductsByName(String productName);
    public List<Product> getProductsByBrand(String productBrand);

    public List<Product> getProductsByPrice(int productPrice);

}