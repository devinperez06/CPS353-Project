package implementations.process;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.Job;
import project.process.Datastore;
import project.process.JobIdentifier;
import project.process.JobRequestResponse;
import project.process.JobRequestResponseCode;
import project.process.SetIDResponse;
import project.process.WriteJobResponse;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TestDatastoreImp {
    @Test
    public void getRecentJobIDTest() {
        Datastore api = Mockito.mock(Datastore.class);
        DatastoreImp datastore = new DatastoreImp(api);
        JobIdentifier jobId = new JobIdentifier(1);
        when(api.getRecentJobID()).thenReturn(jobId);
        if (datastore.getRecentJobID() != api.getRecentJobID().getNum()) {
            fail("Get Recent Job ID test failed.");
        }
    }

    @Test
    public void setIDTest() {
        Datastore api = Mockito.mock(Datastore.class);
        DatastoreImp datastore = new DatastoreImp(api);
        Job mockJob = Mockito.mock(Job.class);
        JobIdentifier mockId = Mockito.mock(JobIdentifier.class);
        SetIDResponse res = () -> "";
        when(api.setID(any(Job.class), any(JobIdentifier.class))).thenReturn(res);
        if (!(datastore.setID(mockJob, mockId)).equals(api.setID(mockJob, mockId).text())) {
            fail("Set ID test failed.");
        }
    }

    @Test
    public void writeJobTest() {
        Datastore api = Mockito.mock(Datastore.class);
        DatastoreImp datastore = new DatastoreImp(api);
        Job mockJob = Mockito.mock(Job.class);
        WriteJobResponse res = () -> "";
        when(api.writeJob(any(Job.class))).thenReturn(res);
        if (!(datastore.writeJob(mockJob)).equals(api.writeJob(mockJob).text())) {
            fail("Write job test failed.");
        }
    }

    @Test
    public void requestJobTest() {
        Datastore api = Mockito.mock(Datastore.class);
        DatastoreImp datastore = new DatastoreImp(api);
        JobIdentifier mockId = Mockito.mock(JobIdentifier.class);
        JobRequestResponse res = new JobRequestResponse() {
            @Override
            public JobRequestResponseCode getResponseCode() {
                return null;
            }

            @Override
            public String text() {
                return "";
            }
        };
        when(api.requestJob(any(JobIdentifier.class))).thenReturn(res);
        if (!(datastore.requestJob(mockId)).equals(api.requestJob(mockId).text())) {
            fail("Request job test failed.");
        }
    }

    @Test
    public void getJobTest() {
        Datastore api = Mockito.mock(Datastore.class);
        DatastoreImp datastore = new DatastoreImp(api);
        JobIdentifier mockId = Mockito.mock(JobIdentifier.class);
        Job job = Mockito.mock(Job.class);
        when(api.getJob(any(JobIdentifier.class))).thenReturn(job);
        if (!(datastore.getJob(mockId).equals(api.getJob(mockId).getHash()))) {
            fail("Get job test failed.");
        }
    }
}
