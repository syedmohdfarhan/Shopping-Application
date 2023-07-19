package BackendApplication.userApi.authenticationApi.authenticationModel;

public class AuthenticateCredentials {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthenticateCredentials{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public AuthenticateCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AuthenticateCredentials() {

    }
}
