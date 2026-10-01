package project.conceptual;

import project.InputForCompute;
import project.annotations.ProcessAPIPrototype;

public class ComputeEngineAPIPrototype {
    @ProcessAPIPrototype
    public void prototypeComputeEngine(ComputeEngine api) {
        OutputValue val = api.solve(new InputForCompute());
        api.sendOutput(val);
    }
}
