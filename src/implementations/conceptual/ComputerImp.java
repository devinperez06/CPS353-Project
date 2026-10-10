package implementations.conceptual;

import project.InputForCompute;
import project.Job;
import project.conceptual.Computer;
import project.conceptual.OutputValue;

public class ComputerImp {
    private final Computer api;

    public ComputerImp(Computer api) {
        this.api = api;
    }

    public int extractInput(Job job) {
        api.extractInput(job);
        return 1;
    }

    public int solve(InputForCompute input) {
        api.solve(input);
        return 1;
    }

    public String sendOutput(OutputValue val) {
        api.sendOutput(val);
        return "";
    }
}
