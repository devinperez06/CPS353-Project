package project.implementations;

import org.junit.jupiter.api.Test;
import project.InputValue;

import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorImpTest {
    @Test
    public void testSolve() {
        InputValue input = new InputValue();
        CalculatorImp imp = new CalculatorImp();
        if (!(imp.solve(input).getResponseCode().success())) {
            fail();
        }
    }
}
