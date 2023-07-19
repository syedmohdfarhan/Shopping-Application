package BackendApplication.exceptionHandler;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message) {
        System.out.println(message);

    }
}
