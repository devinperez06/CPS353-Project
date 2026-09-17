package apidemo.webserver;

public interface WebServer {
    LoginResponse login(LoginRequest loginRequest);

    ProfileLoadResponse loadProfile(UserIdentifier user);

    ProfileChangeResponse updateProfile(UserIdentifier user, ProfileChangeRequest request);

    LogoutResponse logout(UserIdentifier user);
}
