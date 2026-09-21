package apidemo.webserver;

public enum LoginResponseCode {
    SUCCESS(true),
    FAILURE(false);
    private boolean success;

    private LoginResponseCode(boolean success) {
        this.success = success;
    }

    public boolean success() {
        return success;
    }
}