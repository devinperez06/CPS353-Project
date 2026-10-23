package project.conceptual;

import project.annotations.ConceptualAPIPrototype;

public class JobHandlerCalculatorAPIPrototype {
    @ConceptualAPIPrototype
    public void prototypeJobHandlerCalculator(Calculator api) {
        GetInputResponse sendResponse = api.getInput(new InputVal());
        WriteOutputResponse writeResponse = api.writeOutput(new OutputValue());
    }
}
