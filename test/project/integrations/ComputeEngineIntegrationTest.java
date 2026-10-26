package project.integrations;

import org.junit.jupiter.api.Test;
import project.DatastoreTest;
import project.InputConfig;
import project.JobHandler;
import project.OutputConfig;
import project.ResponseCode;
import project.implementations.CalculatorImp;
import project.implementations.ComputeEngineImp;
import project.network.Delimiters;
import project.network.JobSubmissionResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class ComputeEngineIntegrationTest {
    @Test
    public void testComputeEngine() throws IOException {
        InputConfig inputsrc = new InputConfig(new ArrayList<Integer>(List.of(1, 10, 25)));
        OutputConfig outputdest = new OutputConfig(new ArrayList<String>());
        DatastoreTest datastore = new DatastoreTest(inputsrc, outputdest);
        CalculatorImp calculator = new CalculatorImp();
        JobHandler jobHandler = new JobHandler(datastore, calculator);
        ComputeEngineImp engine = new ComputeEngineImp(jobHandler);
        JobSubmissionResponse jobCreationRes = engine.submitJob(inputsrc, outputdest, new Delimiters());
        ResponseCode responseCode = jobCreationRes.getResponseCode();
        String response = jobCreationRes.response();
        if (!(responseCode.success()) && !(response.equals("Job submitted successfully. For output results, see specified output file!"))) {
            fail();
        }
    }
}
