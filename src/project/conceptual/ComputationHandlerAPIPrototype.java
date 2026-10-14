package project.conceptual;

import project.Job;
import project.annotations.ConceptualAPIPrototype;

public class ComputationHandlerAPIPrototype {
    @ConceptualAPIPrototype
    public void prototypeComputationHandler(JobHandler api) {
        SendInputResponse sendResponse = api.sendInput(new Job());
        WriteOutputResponse writeResponse = api.writeOutput(new OutputValue());
    }
}
