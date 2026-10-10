package project;

import project.network.Delimiters;
import project.network.InputSource;
import project.network.OutputSource;

public class Job {
    private String hash;
    private InputSource in;
    private OutputSource out;
    private Delimiters delim;

    public Job(String hash, InputSource in, OutputSource out, Delimiters delim) {
        this.hash = hash;
        this.in = in;
        this.out = out;
        this.delim = delim;
    }

    public Job(InputSource in, OutputSource out, Delimiters delim) {
        this.hash = "abcdefg12345";
        this.in = in;
        this.out = out;
        this.delim = delim;
    }

    public Job() {
        // TODO: defaults
    }

    public String getHash() {
        return hash;
    }

    // TODO: Getters and Job Builder Logic
}
