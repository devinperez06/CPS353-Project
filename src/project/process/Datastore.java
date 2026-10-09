package project.process;

import project.Job;
import project.annotations.ProcessAPI;

@ProcessAPI
public interface Datastore {
    // Get latest ID from storage
    JobIdentifier getRecentJobID();

    // Set incoming job's ID
    SetIDResponse setID(Job job, JobIdentifier jobId);

    // Write job to data storage system
    WriteJobResponse writeJob(Job job);

    // Read job from data storage system
    JobRequestResponse requestJob(JobIdentifier jobId);

    // Return job to compute engine
    Job getJob(JobIdentifier jobId);
}
