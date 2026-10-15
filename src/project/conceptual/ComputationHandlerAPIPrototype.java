package project.conceptual;

import project.annotations.ConceptualAPIPrototype;

public class ComputationHandlerAPIPrototype {
    @ConceptualAPIPrototype
    public void prototypeComputationHandler(JobHandler api) {
        SendInputResponse sendResponse = api.sendInput(new InputVal());
        WriteOutputResponse writeResponse = api.writeOutput(new OutputValue());
    }
}
