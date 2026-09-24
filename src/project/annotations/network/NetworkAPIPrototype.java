package project.annotations.network;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NetworkAPIPrototype {
    public void NetworkAPIPrototype(NetworkAPI api) {
        InputSource in = new InputSource();
        OutputSource out = new OutputSource();
        Delimiters delim = new Delimiters();
        Job job = new Job(in, out, delim);
        JobSubmissionRequest req = new JobSubmissionRequest(job);
        JobSubmissionResponse res = api.submitRequest(req);
    }
}
