package BackendApplication.userApi.authenticationApi.authenticationModel;

public class AuthenticationResponse {
    private int status_code;
    private String status;

    public int getStatus_code() {
        return status_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AuthenticationResponse() {

    }

    public AuthenticationResponse(int status_code, String status) {
        this.status_code = status_code;
        this.status = status;
    }

    @Override
    public String toString() {
        return "AuthenticationResponse{" +
                "status_code=" + status_code +
                ", status='" + status + '\'' +
                '}';
    }
}