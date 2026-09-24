package project.annotations.network;

public class Job {
    private InputSource in;
    private OutputSource out;
    private Delimiters delim;

    public Job(InputSource in, OutputSource out, Delimiters delim) {
        this.in = in;
        this.out = out;
    }

    public InputSource getIn() {
        return in;
    }

    public void setIn(InputSource in) {
        this.in = in;
    }

    public OutputSource getOut() {
        return out;
    }

    public void setOut(OutputSource out) {
        this.out = out;
    }

    public Delimiters getDelim() {
        return delim;
    }

    public void setDelim(Delimiters delim) {
        this.delim = delim;
    }
}
