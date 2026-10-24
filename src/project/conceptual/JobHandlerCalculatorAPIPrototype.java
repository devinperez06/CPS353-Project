package project.conceptual;

import project.Job;
import project.annotations.ConceptualAPIPrototype;

public class JobHandlerCalculatorAPIPrototype {
    @ConceptualAPIPrototype
    public void prototypeJobHandlerCalculator(Calculator api) {
        Job job = new Job();
        //  Get input from job
        GetInputResponse res = api.getInput(job);
        if (res.getResponseCode().success()) {
            // Send output to handler
            SendOutputResponse writeResponse = api.sendOutput(job, new OutputValue());
            if (writeResponse.getResponseCode().success()) {
                System.out.println("Solution sent to handler successfully!");
            }
        }
    }
}
