package project.process;

import project.Job;
import project.OutputValue;
import project.annotations.ProcessAPI;

@ProcessAPI
public interface Datastore {
    // Write output to output destination
    WriteJobResponse writeJob(OutputValue val, Job job);

    // Read input from input source
    ReadJobResponse readJob(Job job);
}
