package project.implementations;

import project.conceptual.Calculator;
import project.conceptual.GetInputResponse;
import project.conceptual.InputVal;
import project.conceptual.OutputValue;
import project.conceptual.WriteOutputResponse;

public class CalculatorImp implements Calculator {

    @Override
    public GetInputResponse getInput(InputVal val) {
        return new GetInputResponse() {
        };
    }

    @Override
    public WriteOutputResponse writeOutput(OutputValue output) {
        return new WriteOutputResponse() {
        };
    }
}
