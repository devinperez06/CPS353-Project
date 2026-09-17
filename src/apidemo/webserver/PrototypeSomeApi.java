package apidemo.webserver;

public class PrototypeSomeApi {
    public void prototype(WebServer server) {
        // log in the user: what do we need to build a LoginRequest?
        LoginResponse loginResponse = server.login(new LoginRequest());
        // load their profile
        if (loginResponse.getResponseCode().success()) {
            ProfileLoadResponse profileLoadResponse = server.loadProfile(loginResponse.getUserIdentifier());

            // make a change to the profile: what do we need to create one of these
            ProfileChangeRequest changeRequest = new ProfileChangeRequest();
            ProfileChangeResponse profileChangeResponse = server.updateProfile(loginResponse.getUserIdentifier(), changeRequest);
            // reload the updated version of the profile
            profileLoadResponse = server.loadProfile(loginResponse.getUserIdentifier());
            // log out
            server.logout(loginResponse.getUserIdentifier());
        }
    }
}
