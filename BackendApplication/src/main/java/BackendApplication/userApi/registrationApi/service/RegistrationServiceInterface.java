package BackendApplication.userApi.registrationApi.service;

import BackendApplication.userApi.registrationApi.model.UserCredentials;

public interface RegistrationServiceInterface {

    public Boolean addUser(UserCredentials userCredentials);
}
