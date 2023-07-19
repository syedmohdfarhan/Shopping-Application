package BackendApplication.getServiceabilityApi.serviceabilityRepository;

import BackendApplication.productDetailsApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceabilityRepository extends JpaRepository<Product,Integer> {

}
