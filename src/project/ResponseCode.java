package project;

public enum ResponseCode {
    SUCCESS(true),
    FAILURE(false),
    INVALID_ARGUMENT(false),
    DIRECTORY_NOT_FOUND(false),
    INVALID_DIRECTORY(false),
    FILE_DOESNT_EXIST(false),
    IO_ERROR(false),
    INTERNAL_ERROR(false);
    private boolean success;

    private ResponseCode(boolean success) {
        this.success = success;
    }

    public boolean success() {
        return success;
    }
}