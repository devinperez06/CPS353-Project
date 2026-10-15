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
        this.in = new InputSource();
        this.out = new OutputSource();
        this.delim = new Delimiters();
    }
}
