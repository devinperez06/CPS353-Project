package implementations.network;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.Job;
import project.network.ComputeEngine;
import project.network.JobSubmissionResponse;
import project.network.LoadFormattedOutputResponse;
import project.network.OutputSource;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class TestComputeEngineImp {
    @Test
    public void TestSubmitJob() {
        ComputeEngine api = Mockito.mock(ComputeEngine.class);
        ComputeEngineImp computeEngine = new ComputeEngineImp(api);
        JobSubmissionResponse res = () -> "";
        when(api.submitJob(any(Job.class))).thenReturn(res);
        Job mockJob = Mockito.mock(Job.class);
        if (!computeEngine.submitJob(mockJob).equals(api.submitJob(mockJob).text())) {
            fail("Submit job error.");
        }
    }

    @Test
    public void loadFormattedOutput() {
        ComputeEngine api = Mockito.mock(ComputeEngine.class);
        ComputeEngineImp computeEngine = new ComputeEngineImp(api);
        LoadFormattedOutputResponse res = () -> "";
        when(api.loadFormattedOutput(any(OutputSource.class))).thenReturn(res);
        OutputSource mockOutput = Mockito.mock(OutputSource.class);
        if (!(computeEngine.loadFormattedOutput(mockOutput).equals(api.loadFormattedOutput(mockOutput).text()))) {
            fail("Load formatted output error.");
        }
    }
}
