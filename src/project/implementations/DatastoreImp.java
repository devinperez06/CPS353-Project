package project.implementations;

import project.InputValue;
import project.Job;
import project.OutputValue;
import project.ResponseCode;
import project.process.Datastore;
import project.process.ReadJobResponse;
import project.process.WriteJobResponse;

public class DatastoreImp implements Datastore {

    @Override
    public WriteJobResponse writeJob(OutputValue val, Job job) {
        return new WriteJobResponse() {
            @Override
            public ResponseCode getResponseCode() {
                return null;
            }
        };
    }

    @Override
    public ReadJobResponse readJob(Job job) {
        return new ReadJobResponse() {
            @Override
            public ResponseCode getResponseCode() {
                return null;
            }

            @Override
            public InputValue getInput() {
                return null;
            }
        };
    }
}
