package project.annotations.network;

//@Target(ElementType.TYPE)
//@Retention(RetentionPolicy.RUNTIME)
public interface NetworkAPI {
    ConfigJobResponse configJobRequest(InputSource in, OutputSource out, Delimiters delim);

    Job configJob(InputSource in, OutputSource out, Delimiters delim);

    JobSubmissionResponse submitJob(Job job);

    LoadFormattedOutputResponse loadFormattedOutput(OutputSource src);
}
