package project;

import project.network.Delimiters;
import project.network.InputSource;
import project.network.OutputDestination;

public class Job {
    static int id = 0;
    private InputSource in;
    private OutputDestination out;
    private Delimiters delim;

    public Job(InputSource in, OutputDestination out, Delimiters delim) {
        this.in = in;
        this.out = out;
        this.delim = delim;
        id += 1;
    }

    public Job(InputSource in, OutputDestination out) {
        this.in = in;
        this.out = out;
        this.delim = new Delimiters(',');
        id += 1;
    }

    public Job() {
        this.in = new InputSource();
        this.out = new OutputDestination();
        this.delim = new Delimiters();
        id += 1;
    }

    public InputSource getInputSource() {
        return in;
    }

    public OutputDestination getOutputDestination() {
        return out;
    }

    public Delimiters getDelim() {
        return delim;
    }

}
