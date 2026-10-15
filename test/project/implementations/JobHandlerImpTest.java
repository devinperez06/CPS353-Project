package project.implementations;

import org.junit.jupiter.api.Test;
import project.Job;
import project.conceptual.OutputValue;

import static org.junit.jupiter.api.Assertions.fail;

public class JobHandlerImpTest {
    @Test
    public void testSendInput() {
        Job job = new Job();
        JobHandlerImp imp = new JobHandlerImp();
        if (!(imp.sendInput(job).toString().equals("Input sent successfully"))) {
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
