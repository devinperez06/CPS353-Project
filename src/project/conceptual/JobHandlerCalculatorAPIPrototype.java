package project.conceptual;

import project.InputValue;
import project.annotations.ConceptualAPIPrototype;

public class JobHandlerCalculatorAPIPrototype {
    @ConceptualAPIPrototype
    public void prototypeJobHandlerCalculator(Calculator api) {
        InputValue input = new InputValue();
        SolveResponse res = api.solve(input);
        if (res.getResponseCode().success()) {
            System.out.println(res.getOutput());
        }
    }
}
