package project.implementations;

import org.junit.jupiter.api.Test;
import project.Job;
import project.OutputValue;

import static org.junit.jupiter.api.Assertions.fail;

public class DatastoreImpTest {
    @Test
    public void testWriteJob() {
        Job job = new Job();
        OutputValue output = new OutputValue();
        DatastoreImp imp = new DatastoreImp();
        if (!(imp.writeJob(output, job).getResponseCode().success())) {
            fail();
        }
    }

    @Test
    public void testReadJob() {
        Job job = new Job();
        DatastoreImp imp = new DatastoreImp();
        if (!(imp.readJob(job)).getResponseCode().success()) {
            fail();
        }
    }
}
