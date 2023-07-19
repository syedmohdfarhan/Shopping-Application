package BackendApplication.userApi.registrationApi.service;

import BackendApplication.userApi.registrationApi.model.UserCredentials;
import BackendApplication.userApi.registrationApi.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService implements RegistrationServiceInterface{
    @Autowired RegistrationRepository registrationRepository;
    @Override
    public Boolean addUser(UserCredentials userCredentials) {
        if(this.registrationRepository.existsByEmail(userCredentials.getEmail())) {
            return false;
        }
        else {
            registrationRepository.save(userCredentials);
            return true;
        }
    }
}
