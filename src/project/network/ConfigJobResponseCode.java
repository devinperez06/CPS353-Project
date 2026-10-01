package project.network;

public enum ConfigJobResponseCode {
    SUCCESS(true),
    FAILURE(false);
    private boolean success;

    private ConfigJobResponseCode(boolean success) {
        this.success = success;
    }

    public boolean success() {
        return success;
    }
}
