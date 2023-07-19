package BackendApplication.userApi.registrationApi.repository;



import BackendApplication.userApi.registrationApi.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//jpa repository consists of methods like save/delete/existsbyid
@Repository
public interface RegistrationRepository extends JpaRepository<UserCredentials,String> {
   Boolean existsByEmail(String email);
}