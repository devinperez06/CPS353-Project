package project.annotations.conceptual;

import project.annotations.InputForCompute;

//@Target(ElementType.TYPE)
//@Retention(RetentionPolicy.RUNTIME)
public interface ComputeEngine {
    // Get output from computation program, given an input
    OutputValue solve(InputForCompute input);

    SendOutputResponse sendOutput(OutputValue val);
}
