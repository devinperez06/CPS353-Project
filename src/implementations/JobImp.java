package implementations;

public class JobImp {
    private InputSourceImp in;
    private OutputSourceImp out;
    private DelimitersImp delim;

    public JobImp(InputSourceImp in, OutputSourceImp out, DelimitersImp delim) {
        this.in = in;
        this.out = out;
        this.delim = delim;
    }
}

