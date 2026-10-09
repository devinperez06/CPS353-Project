package project;

import project.network.Delimiters;
import project.network.InputSource;
import project.network.OutputSource;

public class Job {
    private InputSource in;
    private OutputSource out;
    private Delimiters delim;

    public Job(InputSource in, OutputSource out, Delimiters delim) {
        this.in = in;
        this.out = out;
        this.delim = delim;
    }

    public Job() {
        // TODO: defaults
    }

    // TODO: Getters and Job Builder Logic
}
