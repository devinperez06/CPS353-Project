import implementations.JobImp;
import implementations.network.ComputeEngineImp;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
            fail();
        }
    }
}
