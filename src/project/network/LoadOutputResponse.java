package project.network;

import project.ResponseCode;

public interface LoadOutputResponse {
    ResponseCode getResponseCode();

    String response();
}
