package project.conceptual;

import project.ResponseCode;

import java.util.List;

public interface GetInputResponse {
    ResponseCode getResponseCode();

    List<Integer> inputs(); // returns actual list of inputs
}
