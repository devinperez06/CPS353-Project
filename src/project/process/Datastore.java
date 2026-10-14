package project.process;

import project.Job;
import project.annotations.ProcessAPI;

@ProcessAPI
public interface Datastore {
    // Write job to data storage system
    WriteJobResponse writeJob(Job job);

    // Read job from data storage system
    ReadJobResponse readJob(JobRequest request);
}
