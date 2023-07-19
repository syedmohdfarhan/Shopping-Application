package BackendApplication.getServiceabilityApi.serviceabilityController;

import BackendApplication.getServiceabilityApi.serviceabilityService.ServiceabilityServiceInterface;
import BackendApplication.userApi.authenticationApi.authenticationModel.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ServiceabilityController {
    @Autowired
    ServiceabilityServiceInterface serviceabilityServiceInterface;
    /**
     *  to check if the product is deleiverable at the input pinCode
     @return response entity
     @author syedfarhan
     @params pinCode
     **/
    @GetMapping("/isDeliverable/{id}/{pin}")

    public ResponseEntity<AuthenticationResponse> isDelivered(@PathVariable int pin, @PathVariable int id)  {
        AuthenticationResponse authenticationResponse=new AuthenticationResponse();

        if (serviceabilityServiceInterface.isDelivered(pin,id)) {
            authenticationResponse.setStatus_code(200);
            authenticationResponse.setStatus("success");
            System.out.println("Hello");
            return new ResponseEntity<AuthenticationResponse> (authenticationResponse,HttpStatus.OK);
        }
        else {
            authenticationResponse.setStatus_code(404);
            authenticationResponse.setStatus("not_available");
            return new ResponseEntity<AuthenticationResponse> (HttpStatus.NOT_FOUND);
        }
    }
}
