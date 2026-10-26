package project;

import project.conceptual.Calculator;
import project.conceptual.SolveResponse;
import project.process.Datastore;
import project.process.ReadJobResponse;
import project.process.WriteJobResponse;

import java.io.IOException;

public class JobHandler {
    Datastore datastore;
    Calculator calculator;

    public JobHandler(Datastore datastore, Calculator calculator) {
        this.datastore = datastore;
        this.calculator = calculator;
    }

    public WriteJobResponse writeJob(OutputValue val, Job job) throws IOException {
        return datastore.writeJob(val, job);
    }

    public ReadJobResponse readJob(Job job) throws IOException {
        return datastore.readJob(job);
    }

    public SolveResponse solve(InputValue val) {
        return calculator.solve(val);
    }


}
