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

    public WriteJobResponse writeJob(OutputValue val, Job job) {
        try {
            return datastore.writeJob(val, job);
        } catch (IOException e) {
            return () -> ResponseCode.IO_ERROR;
        }
    }

    public ReadJobResponse readJob(Job job) {
        try {
            return datastore.readJob(job);
        } catch (IOException e) {
            return new ReadJobResponse() {
                @Override
                public ResponseCode getResponseCode() {
                    return ResponseCode.IO_ERROR;
                }

                @Override
                public InputValue getInput() {
                    return null;
                }
            };
        }
    }

    public SolveResponse solve(InputValue val) {
        return calculator.solve(val);
    }
}
