package project.implementations;

import org.junit.jupiter.api.Test;
import project.Job;
import project.network.Delimiters;
import project.network.InputSource;
import project.network.OutputSource;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;

public class ComputeEngineImpTest {
    @Test
    public void testCreateJob() {
        InputSource input = new InputSource();
        OutputSource output = new OutputSource();
        Delimiters delim = new Delimiters();
        Job job = new Job(input, output, delim);
        ComputeEngineImp imp = new ComputeEngineImp();
        if (!Objects.equals(imp.createJob(input, output, delim).getJob(), job)) {
            fail();
        }
    }

    @Test
    public void testSubmitJob() {
        Job job = new Job();
        ComputeEngineImp imp = new ComputeEngineImp();
        if (!imp.submitJob(job).toString().equals("Test successfully submitted")) {
            fail();
        }
    }

    @Test
    public void testLoadOutput() {
        Job job = new Job();
        ComputeEngineImp imp = new ComputeEngineImp();
        if (!(imp.loadOutput(job).toString().equals("Output loaded successfully"))) {
            fail();
        }
    }
}
