package project.implementations;

import org.junit.jupiter.api.Test;
import project.Job;
import project.OutputValue;
import project.ResponseCode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class DatastoreImpTest {
    @Test
    public void testWriteJob() {
        Job job = new Job();
        OutputValue output = new OutputValue(List.of(5));
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

    @Test
    public void testWriteJobNullOutputValue() {
        Job job = new Job();
        OutputValue val = null;
        DatastoreImp imp = new DatastoreImp();
        if (!imp.writeJob(val, job).getResponseCode().equals(ResponseCode.INVALID_ARGUMENT)) {
            fail();
        }
    }

    @Test
    public void testReadJobNullJob() {
        Job job = null;
        DatastoreImp imp = new DatastoreImp();
        if (!imp.readJob(job).getResponseCode().equals(ResponseCode.INVALID_ARGUMENT)) {
            fail();
        }
    }
}
