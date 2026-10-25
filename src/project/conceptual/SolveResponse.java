package project.conceptual;

import project.OutputValue;
import project.ResponseCode;

public interface SolveResponse {
    ResponseCode getResponseCode();

    OutputValue getOutput();
}
