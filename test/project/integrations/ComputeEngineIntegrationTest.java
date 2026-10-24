package project.integrations;

import org.junit.jupiter.api.Test;
import project.DatastoreTest;
import project.InputConfig;
import project.Job;
import project.JobHandler;
import project.OutputConfig;
import project.conceptual.SolveResponse;
import project.implementations.CalculatorImp;
import project.implementations.ComputeEngineImp;
import project.network.Delimiters;
import project.network.JobCreationResponse;
import project.process.ReadJobResponse;
import project.process.WriteJobResponse;

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
        JobCreationResponse jobCreationRes = engine.createJob(inputsrc, outputdest, new Delimiters());
        Job job = jobCreationRes.getJob();
        ReadJobResponse readRes = jobHandler.readJob(job);
        SolveResponse solveRes = jobHandler.solve(readRes.getInput());
        WriteJobResponse writeRes = jobHandler.writeJob(solveRes.getOutput(), job);
        if (!writeRes.getResponseCode().success()) {
            fail();
        }
        if (!(engine.loadOutput(job).response().equals("1:0,10:18,25:101"))) {
            fail();
        }
    }
}
