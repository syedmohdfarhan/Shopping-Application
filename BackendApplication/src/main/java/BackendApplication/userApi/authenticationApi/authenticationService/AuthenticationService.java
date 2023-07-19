package BackendApplication.userApi.authenticationApi.authenticationService;

import BackendApplication.exceptionHandler.UserNotFoundException;
import BackendApplication.userApi.authenticationApi.authenticationModel.AuthenticateCredentials;
import BackendApplication.userApi.authenticationApi.authenticationRepository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements AuthenticationServiceInterface{
    @Autowired
    AuthenticationRepository authenticationRepository;
    @Override
    public Boolean authenticateUser(AuthenticateCredentials authenticateCredentials)  throws UserNotFoundException {
        if(this.authenticationRepository.existsByEmailAndPassword(authenticateCredentials.getEmail(), authenticateCredentials.getPassword())){
            return true;
        }
        else {
            //return false;
            throw new UserNotFoundException("Invalid Credentials");
        }
    }
}
