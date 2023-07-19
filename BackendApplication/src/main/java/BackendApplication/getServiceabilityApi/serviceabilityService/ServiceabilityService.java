package BackendApplication.getServiceabilityApi.serviceabilityService;

import BackendApplication.getServiceabilityApi.serviceabilityModel.ProductService;
import BackendApplication.getServiceabilityApi.serviceabilityRepository.ServiceabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServiceabilityService implements ServiceabilityServiceInterface {
    @Autowired
    ServiceabilityRepository serviceabilityRepository;

    @Override
    public boolean isDelivered(int pinCode, int id) {


        if (this.serviceabilityRepository.existsById(id)) {
            Set<ProductService> productServices = this.serviceabilityRepository.findById(id).get().getProduct_pin();
            System.out.println(productServices);
            for (ProductService pin : productServices) {
                if (pin.getPinCode() == pinCode) {
                    return true;
                }

            }
            return false;

        }
        return false;
    }

}