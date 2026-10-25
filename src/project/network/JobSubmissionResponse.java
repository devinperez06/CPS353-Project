package project.network;

import project.ResponseCode;

public interface JobSubmissionResponse {
    ResponseCode getResponseCode();

    String response();

}
