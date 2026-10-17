package project.implementations;

import project.conceptual.InputVal;
import project.conceptual.JobHandler;
import project.conceptual.OutputValue;
import project.conceptual.SendInputResponse;
import project.conceptual.WriteOutputResponse;

public class JobHandlerImp implements JobHandler {

    @Override
    public SendInputResponse sendInput(InputVal val) {
        return new SendInputResponse() {
        };
    }

    @Override
    public WriteOutputResponse writeOutput(OutputValue output) {
        return new WriteOutputResponse() {
        };
    }
}
