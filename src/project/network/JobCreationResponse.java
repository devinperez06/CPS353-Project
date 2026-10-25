package project.network;

import project.Job;
import project.ResponseCode;

public interface JobCreationResponse {
    ResponseCode getResponseCode();

    Job getJob();
}
