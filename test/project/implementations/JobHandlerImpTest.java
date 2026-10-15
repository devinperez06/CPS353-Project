package project.implementations;

import org.junit.jupiter.api.Test;
import project.conceptual.InputVal;
import project.conceptual.OutputValue;

import static org.junit.jupiter.api.Assertions.fail;

public class JobHandlerImpTest {
    @Test
    public void testSendInput() {
        InputVal val = new InputVal();
        JobHandlerImp imp = new JobHandlerImp();
        if (!(imp.sendInput(val).toString().equals("Input sent successfully"))) {
            fail();
        }
    }

    @Test
    public void testWriteOutput() {
        OutputValue value = new OutputValue();
        JobHandlerImp imp = new JobHandlerImp();
        if (!(imp.writeOutput(value).toString().equals("Output written successfully"))) {
            fail();
        }
    }
}
