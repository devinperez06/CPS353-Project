package project.process;

import project.InputValue;
import project.ResponseCode;

public interface ReadJobResponse {
    ResponseCode getResponseCode();

    InputValue getInput();
}
