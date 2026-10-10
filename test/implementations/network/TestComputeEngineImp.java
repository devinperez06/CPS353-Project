package implementations.network;

import implementations.JobImp;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.network.OutputSource;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class TestComputeEngineImp {
    @Test
    public void TestSubmitJob() {
        ComputeEngineImp mockEngine = Mockito.mock(ComputeEngineImp.class);
        when(mockEngine.submitJob(any(JobImp.class))).thenReturn("Job submitted");
        ComputeEngineImp actualEngine = new ComputeEngineImp();
        JobImp mockJob = Mockito.mock(JobImp.class);
        if (!actualEngine.submitJob(mockJob).equals(mockEngine.submitJob(mockJob))) {
            fail("Submit job error");
        }
    }

    @Test
    public void loadFormattedOutput() {
        ComputeEngineImp mockEngine = Mockito.mock(ComputeEngineImp.class);
        when(mockEngine.loadFormattedOutput(any(OutputSource.class))).thenReturn("Your answer is [BLANK].");
        ComputeEngineImp actualEngine = new ComputeEngineImp();
        OutputSource mockOutput = Mockito.mock(OutputSource.class);
        if (!(actualEngine.loadFormattedOutput(mockOutput).equals(mockEngine.loadFormattedOutput(mockOutput)))) {
            fail("Load formatted output error");
        }
    }
}
