package project.process;

public interface JobRequestResponse {
    JobRequestResponseCode getResponseCode();

    String text(); // Generate user-friendly output based on response code

}
