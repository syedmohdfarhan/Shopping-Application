package BackendApplication.userApi.registrationApi.registrationController;


import BackendApplication.userApi.registrationApi.DTO.DTOConverter;
import BackendApplication.userApi.registrationApi.model.UserCredentials;
import BackendApplication.userApi.registrationApi.model.UserDto;
import BackendApplication.userApi.registrationApi.service.RegistrationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class RegistrationController {
    @Autowired
    RegistrationServiceInterface registrationServiceInterface;
    /**
     *  to add the user to database
     @return response entity
     @author syedfarhan
     @params userInputDetails
     **/

    @PostMapping("/addUser")
    public ResponseEntity<UserCredentials> addUser(@RequestBody UserDto userdto){
      if(userdto.getPassword().equals(userdto.getConfirmPassword())) {
          UserCredentials userCredentials = DTOConverter.convertUserDtoToUserCredentials(userdto);
          if (registrationServiceInterface.addUser(userCredentials)) {
              return new ResponseEntity<UserCredentials> (HttpStatus.OK);
          }
          else {
              return new ResponseEntity<UserCredentials> (HttpStatus.CONFLICT);
          }
      }
       else
          return new ResponseEntity<UserCredentials> (HttpStatus.BAD_GATEWAY);
    }
}
