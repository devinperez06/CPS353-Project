package apidemo.webserver;

public interface LoginResponse {
    LoginResponseCode getResponseCode();

    UserIdentifier getUserIdentifier();
}