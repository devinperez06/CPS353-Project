package implementations.process;

import implementations.JobImp;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.process.JobIdentifier;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

public class TestDatastoreImp {
    @Test
    public void getRecentJobIDTest() {
        DataStoreImp mockStore = Mockito.mock(DataStoreImp.class);
        when(mockStore.getRecentJobID()).thenReturn(5);
        DataStoreImp actualStore = new DataStoreImp();
        if (mockStore.getRecentJobID() != actualStore.getRecentJobID()) {
            fail("Get Recent Job ID test failed.");
        }
    }

    @Test
    public void setIDTest() {
        DataStoreImp mockStore = Mockito.mock(DataStoreImp.class);
        JobImp mockJob = Mockito.mock(JobImp.class);
        JobIdentifier jobId = new JobIdentifier();
        when(mockStore.setID(mockJob, jobId)).thenReturn("ID successfully set.");
        DataStoreImp actualStore = new DataStoreImp();
        if (!(mockStore.setID(mockJob, jobId)).equals(actualStore.setID(mockJob, jobId))) {
            fail("Set ID test failed.");
        }
    }

    @Test
    public void writeJobTest() {
        DataStoreImp mockStore = Mockito.mock(DataStoreImp.class);
        JobImp mockJob = Mockito.mock(JobImp.class);
        when(mockStore.writeJob(mockJob)).thenReturn("Job written successfully.");
        DataStoreImp actualStore = new DataStoreImp();
        if (!(mockStore.writeJob(mockJob)).equals(actualStore.writeJob(mockJob))) {
            fail("Write job test failed.");
        }
    }

    @Test
    public void requestJobTest() {
        DataStoreImp mockStore = Mockito.mock(DataStoreImp.class);
        JobImp mockJob = Mockito.mock(JobImp.class);
        when(mockStore.requestJob(mockJob)).thenReturn("Job requested successfully.");
        DataStoreImp actualStore = new DataStoreImp();
        if (!(mockStore.requestJob(mockJob)).equals(actualStore.requestJob(mockJob))) {
            fail("Request job test failed.");
        }
    }

    // Todo: Write test for getting a job
}
