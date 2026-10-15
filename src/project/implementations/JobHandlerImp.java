package project.implementations;

import project.Job;
import project.conceptual.JobHandler;
import project.conceptual.OutputValue;
import project.conceptual.SendInputResponse;
import project.conceptual.WriteOutputResponse;

public class JobHandlerImp implements JobHandler {

    @Override
    public SendInputResponse sendInput(Job job) {
        return new SendInputResponse() {
        };
    }

    @Override
    public WriteOutputResponse writeOutput(OutputValue output) {
        return new WriteOutputResponse() {
        };
    }
}
