package project;

public enum ResponseCode {
    SUCCESS(true),
    FAILURE(false);
    private boolean success;

    private ResponseCode(boolean success) {
        this.success = success;
    }

    public boolean success() {
        return success;
    }
}