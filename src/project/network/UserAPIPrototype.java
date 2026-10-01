package project.network;

import project.Job;
import project.annotations.NetworkAPIPrototype;

//@Target(ElementType.METHOD)
//@Retention(RetentionPolicy.RUNTIME)
public class UserAPIPrototype {
    @NetworkAPIPrototype
    public void prototypeUser(User api) {
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
