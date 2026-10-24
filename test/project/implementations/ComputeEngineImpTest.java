package project.implementations;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.Job;
import project.JobHandler;
import project.network.Delimiters;
import project.network.InputSource;
import project.network.OutputDestination;

import static org.junit.jupiter.api.Assertions.fail;

public class ComputeEngineImpTest {
    @Test
    public void testCreateJob() {
        InputSource input = new InputSource();
        OutputDestination output = new OutputDestination();
        Delimiters delim = new Delimiters();
        JobHandler jobHandler = Mockito.mock(JobHandler.class);
        ComputeEngineImp imp = new ComputeEngineImp(jobHandler);
        if (!(imp.createJob(input, output, delim).getResponseCode().success())) {
            fail();
        }
    }

    @Test
    public void testLoadOutput() {
        Job job = new Job();
        JobHandler jobHandler = Mockito.mock(JobHandler.class);
        ComputeEngineImp imp = new ComputeEngineImp(jobHandler);
        if (!(imp.loadOutput(job).getResponseCode().success())) {
            fail();
        }
    }
}
