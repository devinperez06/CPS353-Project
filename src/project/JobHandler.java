package project;

import project.conceptual.Calculator;
import project.conceptual.SolveResponse;
import project.process.Datastore;
import project.process.ReadJobResponse;
import project.process.WriteJobResponse;

public class JobHandler {
    Datastore datastore;
    Calculator calculator;

    public JobHandler(Datastore datastore, Calculator calculator) {
        this.datastore = datastore;
        this.calculator = calculator;
    }

    public WriteJobResponse writeJob(OutputValue val, Job job) {
        return datastore.writeJob(val, job);
    }

    public ReadJobResponse readJob(Job job) {
        return datastore.readJob(job);
    }

    public SolveResponse solve(InputValue val) {
        return calculator.solve(val);
    }


}
