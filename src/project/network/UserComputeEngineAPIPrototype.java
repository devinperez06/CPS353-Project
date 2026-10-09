package project.network;

import project.Job;
import project.annotations.NetworkAPIPrototype;

//@Target(ElementType.METHOD)
//@Retention(RetentionPolicy.RUNTIME)
public class UserComputeEngineAPIPrototype {
    @NetworkAPIPrototype
    public void prototypeUserComputeEngine(ComputeEngine api) {
        // Submit a job
        InputSource in = new InputSource();
        OutputSource out = new OutputSource();
        Delimiters delim = new Delimiters();
        JobSubmissionResponse res = api.submitJob(new Job(in, out, delim));
        System.out.println(res);
        // Load a response
        OutputSource solvedOut = new OutputSource();
        LoadFormattedOutputResponse lRes = api.loadFormattedOutput(solvedOut);
        System.out.println(lRes);
    }
}
