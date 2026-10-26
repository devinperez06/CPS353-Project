package project.implementations;

import project.InputValue;
import project.OutputValue;
import project.ResponseCode;
import project.conceptual.Calculator;
import project.conceptual.SolveResponse;

import java.util.ArrayList;
import java.util.List;

public class CalculatorImp implements Calculator {
    @Override
    public SolveResponse solve(InputValue input) {
        // Initialize a bad response to re-use
        SolveResponse badRes = new SolveResponse() {
            @Override
            public ResponseCode getResponseCode() {
                return ResponseCode.FAILURE;
            }

            @Override
            public OutputValue getOutput() {
                return null;
            }
        };
        // Check for null values
        if (input == null) {
            return badRes;
        }
        // Check for empty list
        List<Integer> inputList = input.getInputs();
        if (inputList.isEmpty()) {
            return badRes;
        }
        // Check for invalid inputs
        for (Integer i : inputList) {
            if (i == null | i < 1) {
                return badRes;
            }
        }
        // Solve
        ArrayList<Integer> solution = new ArrayList<>();
        for (int index = 0; index < inputList.size(); index++) {
            int n = inputList.get(index);
            int sum = 0;
            for (int j = n - 1; j > 1; j--) {
                if (isPrime(j)) {
                    sum += j;
                }
            }
            solution.add(sum);
        }

        OutputValue output = new OutputValue(solution);
        return new SolveResponse() {
            @Override
            public ResponseCode getResponseCode() {
                return ResponseCode.SUCCESS;
            }

            @Override
            public OutputValue getOutput() {
                return output;
            }
        };
    }

    private boolean isPrime(int j) {
        if (j == 1) {
            return false;
        }
        for (int i = 2; i <= j / i; i++) {
            if (j % i == 0) {
                return false;
            }
        }
        return true;
    }
}
