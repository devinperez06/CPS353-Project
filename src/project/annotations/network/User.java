package project.annotations.network;

import project.annotations.Job;

//@Target(ElementType.TYPE)
//@Retention(RetentionPolicy.RUNTIME)
// Network API
public interface User {
    ConfigJobResponse configJobRequest(InputSource in, OutputSource out, Delimiters delim);

    Job configJob(InputSource in, OutputSource out, Delimiters delim);

    JobSubmissionResponse submitJob(Job job);

    LoadFormattedOutputResponse loadFormattedOutput(OutputSource src);
}
