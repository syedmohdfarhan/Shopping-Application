package BackendApplication.productDetailsApi.controller;

import BackendApplication.exceptionHandler.ProductNotFoundException;
import BackendApplication.productDetailsApi.model.Product;
import BackendApplication.productDetailsApi.service.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
    @Autowired ProductServiceInterface productServiceInterface;

    /**
     *  to add the product to databse table of name product_data
     @return response entity
     @author syedfarhan
     @params productDetails
     **/
    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        if (productServiceInterface.addProduct(product)) {
            return new ResponseEntity<Product> (HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Product> (HttpStatus.CONFLICT);
        }
    }


    /**
     *  to get the product of particular id from product_data table
     @return response entity
     @author syedfarhan
     @params productId
     **/
    @GetMapping("/getProduct/{productId}")
    public ResponseEntity<Product> getProductByProductCode(@PathVariable int productid) throws ProductNotFoundException{
        Product getproduct =productServiceInterface.getProductByProductCode(productid);
        if(getproduct!=null) {
            return new ResponseEntity<Product>(getproduct,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }


    /**
     *  to get all the product of same name from the product_data table
     @return response entity
     @author syedfarhan
     @params productByName
     **/
    @GetMapping("/getAllProductsByName/{productName}")
    public ResponseEntity<List<Product>> getProductByName(@PathVariable String productName) throws ProductNotFoundException {
        List<Product> allProductsByName=productServiceInterface.getProductByName(productName);

        if(allProductsByName==null) {
            System.out.println("No Product Available");
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<Product>>(allProductsByName,HttpStatus.OK);
        }
    }


    /**
     *  to get all the product of same brand from the product_data table
     @return response entity
     @author syedfarhan
     @params productByBrand
     **/
    @GetMapping("/getAllProductsByBrand/{productBrand}")
    public ResponseEntity<List<Product>> getProductByBrand(@PathVariable String productBrand) throws ProductNotFoundException{
        List<Product> allProductsByBrand=productServiceInterface.getProductByBrand(productBrand);

        if(allProductsByBrand==null) {
            System.out.println("No Product Available");
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<Product>>(allProductsByBrand,HttpStatus.OK);
        }
    }


    /**
     *  to get all the product of same brand from the product_data table
     @return response entity
     @author syedfarhan
     @params productByPrice
     **/

    @GetMapping("/getAllProductsByPrice/{productPrice}")
    public ResponseEntity<List<Product>> getProductByPrice(@PathVariable int productPrice){
        List<Product> allProductsByPrice=productServiceInterface.getProductByPrice(productPrice);

        if(allProductsByPrice==null) {
            System.out.println("No Product Available");
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<List<Product>>(allProductsByPrice,HttpStatus.OK);
        }
    }


}
