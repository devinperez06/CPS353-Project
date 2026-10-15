package project.implementations;

import org.junit.jupiter.api.Test;
import project.Job;
import project.JobIdentifier;
import project.process.JobRequest;

import static org.junit.jupiter.api.Assertions.fail;

public class DatastoreImpTest {
    @Test
    public void testWriteJob() {
        Job job = new Job();
        DatastoreImp imp = new DatastoreImp();
        if (!(imp.writeJob(job).toString().equals("Job written successfully!"))) {
            fail();
        }
    }

    @Test
    public void testReadJob() {
        JobRequest request = new JobRequest(new JobIdentifier());
        DatastoreImp imp = new DatastoreImp();
        if (!(imp.readJob(request)).toString().equals("Job read successfully")) {
            fail();
        }
    }
}
