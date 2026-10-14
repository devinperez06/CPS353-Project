package project.conceptual;

import project.InputForCompute;
import project.Job;
import project.annotations.ConceptualAPIPrototype;

public class HandlerComputerPrototype {
    @ConceptualAPIPrototype
    public void prototypeHandlerComputer(Computer api) {
        InputForCompute num = api.extractInput(new Job());
        OutputValue val = api.solve(num);
        SendOutputResponse res = api.sendOutput(val);
        System.out.println(res);
    }
}
