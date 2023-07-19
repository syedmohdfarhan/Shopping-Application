package BackendApplication.userApi.registrationApi.DTO;

import BackendApplication.userApi.registrationApi.model.UserCredentials;
import BackendApplication.userApi.registrationApi.model.UserDto;
public class DTOConverter {
    public static UserCredentials convertUserDtoToUserCredentials(UserDto userDto){
        UserCredentials userCredentials=new UserCredentials();
        userCredentials.setFirstName(userDto.getFirstName());
        userCredentials.setLastName(userDto.getLastName());
        userCredentials.setEmail(userDto.getEmail());
        userCredentials.setPassword(userDto.getPassword());
    return userCredentials;
    }
}
