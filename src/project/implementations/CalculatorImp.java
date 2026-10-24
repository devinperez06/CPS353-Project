package project.implementations;

import project.InputValue;
import project.OutputValue;
import project.ResponseCode;
import project.conceptual.Calculator;
import project.conceptual.SolveResponse;

public class CalculatorImp implements Calculator {

    @Override
    public SolveResponse solve(InputValue input) {
        return new SolveResponse() {
            @Override
            public ResponseCode getResponseCode() {
                return null;
            }

            @Override
            public OutputValue getOutput() {
                return null;
            }
        };
    }
}
