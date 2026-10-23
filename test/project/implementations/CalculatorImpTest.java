package project.implementations;

import org.junit.jupiter.api.Test;
import project.conceptual.InputVal;
import project.conceptual.OutputValue;

import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorImpTest {
    @Test
    public void testGetInput() {
        InputVal val = new InputVal();
        CalculatorImp imp = new CalculatorImp();
        if (!(imp.getInput(val).toString().equals("Input sent successfully"))) {
            fail();
        }
    }

    @Test
    public void testWriteOutput() {
        OutputValue value = new OutputValue();
        CalculatorImp imp = new CalculatorImp();
        if (!(imp.writeOutput(value).toString().equals("Output written successfully"))) {
            fail();
        }
    }
}
