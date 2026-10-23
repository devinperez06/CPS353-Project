package project.integrations;

import org.junit.jupiter.api.Test;
import project.DatastoreTest;
import project.InputConfig;
import project.Job;
import project.JobHandler;
import project.OutputConfig;
import project.conceptual.GetInputResponse;
import project.conceptual.InputVal;
import project.conceptual.OutputValue;
import project.conceptual.WriteOutputResponse;
import project.implementations.CalculatorImp;
import project.implementations.ComputeEngineImp;
import project.network.Delimiters;
import project.network.JobCreationResponse;
import project.network.JobSubmissionResponse;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class ComputeEngineIntegrationTest {
    @Test
    public void testComputeEngine() {
        ComputeEngineImp engine = new ComputeEngineImp();
        InputConfig inputsrc = new InputConfig(new ArrayList<Integer>(List.of(1, 10, 25)));
        OutputConfig outputsrc = new OutputConfig(new ArrayList<String>());
        JobCreationResponse jobCreationRes = engine.createJob(inputsrc, outputsrc, new Delimiters());
        Job job = jobCreationRes.getJob();
        JobSubmissionResponse jobSubmissionRes = engine.submitJob(job);
        DatastoreTest datastore = new DatastoreTest(inputsrc, outputsrc);
        CalculatorImp calculator = new CalculatorImp();
        JobHandler jobHandler = new JobHandler(datastore, calculator);
        List<Integer> inputs = datastore.readInputs();
        GetInputResponse sendInputRes = calculator.getInput(new InputVal(datastore.readInputs()));
        OutputValue output = new OutputValue();
        WriteOutputResponse writeOutputRes = calculator.writeOutput(new OutputValue());
        List<String> outputs = datastore.writeOutput("1:0,10:18,25:101");
        if (!(output.toString().equals(outputs.get(0)))) {
            fail();
        }
    }
}
