package project.implementations;

import org.junit.jupiter.api.Test;
import project.InputValue;
import project.OutputValue;
import project.ResponseCode;
import project.conceptual.SolveResponse;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorImpTest {
    @Test
    public void testSolve() {
        InputValue input = new InputValue(List.of(5));
        CalculatorImp imp = new CalculatorImp();
        SolveResponse res = imp.solve(input);
        ResponseCode responseCode = res.getResponseCode();
        OutputValue outputValue = res.getOutput();
        if (!(responseCode.success()) || !(outputValue.getOutput().equals("5"))) {
            fail();
        }
    }
}
