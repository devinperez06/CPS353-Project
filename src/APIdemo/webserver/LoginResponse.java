package APIdemo.webserver;

public interface LoginResponse {
    LoginResponseCode getResponseCode();

    UserIdentifier getUserIdentifier();
}