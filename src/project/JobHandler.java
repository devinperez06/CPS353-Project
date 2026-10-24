package project;

import project.conceptual.Calculator;
import project.conceptual.GetInputResponse;
import project.conceptual.OutputValue;
import project.conceptual.SendOutputResponse;
import project.process.Datastore;
import project.process.JobRequest;
import project.process.ReadJobResponse;
import project.process.WriteJobResponse;

public class JobHandler {
    Datastore datastore;
    Calculator calculator;

    public JobHandler(Datastore datastore, Calculator calculator) {
        this.datastore = datastore;
        this.calculator = calculator;
    }

    public WriteJobResponse writeJob(Job job) {
        return datastore.writeJob(job);
    }

    public ReadJobResponse readJob(JobRequest req) {
        return datastore.readJob(req);
    }

    public GetInputResponse getInput(Job job) {
        return calculator.getInput(job);
    }

    public SendOutputResponse writeOutput(OutputValue val) {
        return calculator.sendOutput(val);
    }


}
