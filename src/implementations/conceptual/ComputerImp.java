package implementations.conceptual;

import project.InputForCompute;
import project.Job;
import project.conceptual.Computer;

public class ComputerImp {
    static Computer computer;

    public int extractInput(Job job) {
        return new InputForComputeImp(0).getInput();
    }

    public int solve(InputForCompute input) {
        return new OutputValueImp(0).getOutput();
    }

    public String sendOutput(OutputValueImp val) {
        return new SendOutputResponseImp().text();
    }
}
