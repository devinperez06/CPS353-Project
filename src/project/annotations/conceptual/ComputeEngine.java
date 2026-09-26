package project.annotations.conceptual;

//@Target(ElementType.TYPE)
//@Retention(RetentionPolicy.RUNTIME)
public interface ComputeEngine {
    // Get output from computation program, given an input
    OutputValue solve(InputforCompute input);

    SendOutputResponse sendOutput(OutputValue val);
}
