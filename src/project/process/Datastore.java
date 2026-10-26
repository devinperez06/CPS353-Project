package project.process;

import project.Job;
import project.OutputValue;
import project.annotations.ProcessAPI;

import java.io.IOException;

@ProcessAPI
public interface Datastore {
    // Write output to output destination
    WriteJobResponse writeJob(OutputValue val, Job job) throws IOException;

    // Read input from input source
    ReadJobResponse readJob(Job job) throws IOException;
}
