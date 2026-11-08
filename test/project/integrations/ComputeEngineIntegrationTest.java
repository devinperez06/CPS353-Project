package project.integrations;

import org.junit.jupiter.api.Test;
import project.DatastoreTest;
import project.InputConfig;
import project.JobHandler;
import project.OutputConfig;
import project.ResponseCode;
import project.implementations.CalculatorImp;
import project.implementations.ComputeEngineImp;
import project.implementations.DatastoreImp;
import project.network.Delimiters;
import project.network.InputSource;
import project.network.JobSubmissionResponse;
import project.network.OutputDestination;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class ComputeEngineIntegrationTest {
    @Test
    public void testComputeEngine() {
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

    @Test
    public void testComputeEngineInvalidInput() {
        InputSource inputsrc = new InputSource("src/project/sources/input2.txt");
        OutputDestination outputdest = new OutputDestination("src/project/sources/output2.txt");
        DatastoreImp datastore = new DatastoreImp();
        CalculatorImp calculator = new CalculatorImp();
        JobHandler jobHandler = new JobHandler(datastore, calculator);
        ComputeEngineImp engine = new ComputeEngineImp(jobHandler);
        JobSubmissionResponse res = engine.submitJob(inputsrc, outputdest, new Delimiters());
        if (!(res.getResponseCode().equals(ResponseCode.FAILURE)) || !(res.response().equals("Null output value returned by solve operation."))) {
            fail();
        }
    }
}
