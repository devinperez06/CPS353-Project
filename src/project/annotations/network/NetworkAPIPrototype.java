package project.annotations.network;

import project.annotations.Job;

//@Target(ElementType.METHOD)
//@Retention(RetentionPolicy.RUNTIME)
public class NetworkAPIPrototype {
    public void prototype(User api) {
        InputSource in = new InputSource();
        OutputSource out = new OutputSource();
        Delimiters delim = new Delimiters();
        ConfigJobResponse res = api.configJobRequest(in, out, delim);
        if (res.getResponseCode().success()) {
            Job job = api.configJob(in, out, delim);
            JobSubmissionResponse jsRes = api.submitJob(job);
        }
    }
}
