package project.annotations.process;

import project.annotations.InputForCompute;
import project.annotations.Job;

//@Target(ElementType.TYPE)
//@Retention(RetentionPolicy.RUNTIME)
// Process API
public interface Datastore {
    // Get latest ID from storage
    JobIdentifier getRecentJobID();

    // Set incoming job's ID
    SetIDResponse setID(Job job, JobIdentifier jID);

    // Check if job is complete
    CompleteStatus isComplete(Job job);

    // Write job to data storage system
    WriteJobResponse writeJob(Job job, CompleteStatus status);

    // Read job from data storage system
    JobRequestResponse requestJob(JobIdentifier jID);

    // Return job to compute engine
    Job getJob(JobIdentifier jID);

    // Format input for compute engine
    InputForCompute extractInputFromJob(Job job);
}
