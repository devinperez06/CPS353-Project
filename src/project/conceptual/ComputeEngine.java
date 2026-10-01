package project.conceptual;

import project.InputForCompute;
import project.annotations.ProcessAPI;

@ProcessAPI
public interface ComputeEngine {
    // Get output from computation program, given an input
    OutputValue solve(InputForCompute input);

    SendOutputResponse sendOutput(OutputValue val);
}
