package project.implementations;

import org.junit.jupiter.api.Test;
import project.Job;
import project.OutputValue;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class DatastoreImpTest {
    @Test
    public void testWriteJob() throws IOException {
        Job job = new Job();
        OutputValue output = new OutputValue(List.of(5));
        DatastoreImp imp = new DatastoreImp();
        if (!(imp.writeJob(output, job).getResponseCode().success())) {
            fail();
        }
    }

    @Test
    public void testReadJob() throws IOException {
        Job job = new Job();
        DatastoreImp imp = new DatastoreImp();
        if (!(imp.readJob(job)).getResponseCode().success()) {
            fail();
        }
    }
}
