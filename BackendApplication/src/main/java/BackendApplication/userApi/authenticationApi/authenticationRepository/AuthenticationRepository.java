package BackendApplication.userApi.authenticationApi.authenticationRepository;

import BackendApplication.userApi.registrationApi.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepository  extends JpaRepository<UserCredentials,String> {
    Boolean existsByEmailAndPassword(String email,String password);
}
