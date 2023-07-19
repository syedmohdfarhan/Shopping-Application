package BackendApplication.userApi.authenticationApi.authenticationController;

import BackendApplication.exceptionHandler.UserNotFoundException;
import BackendApplication.userApi.authenticationApi.authenticationModel.AuthenticateCredentials;
import BackendApplication.userApi.authenticationApi.authenticationModel.AuthenticationResponse;
import BackendApplication.userApi.authenticationApi.authenticationService.AuthenticationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {
    @Autowired
    AuthenticationServiceInterface authenticationServiceInterface;

    /**
     *  to authenticate the user
     @return response entity
     @author syedfarhan
     @params userAuthenticationDetails
     **/

    @PostMapping("/authenticateUser")

    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody AuthenticateCredentials authenticateCredentials) throws UserNotFoundException {
        AuthenticationResponse authRes =new AuthenticationResponse();
        if (authenticationServiceInterface.authenticateUser(authenticateCredentials)) {
            //this data was returned by database
            authRes.setStatus_code(200);
            authRes.setStatus("success");
            return new ResponseEntity<AuthenticationResponse> (authRes,HttpStatus.OK);
        }
        else {
            authRes.setStatus_code(405);
            authRes.setStatus("failed");
            return new ResponseEntity<AuthenticationResponse>(authRes,HttpStatus.NOT_FOUND);
        }

           }
}
