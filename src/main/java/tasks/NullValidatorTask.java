package tasks;

import validator.Validator;

import java.util.concurrent.Callable;

public class NullValidatorTask implements Callable<Boolean> {
    // Member variable of this class
    private String message;
    private Validator validator;

    // Constructor of this class
    public NullValidatorTask(String message, Validator validator) {
        // This keyword refers to current instance itself
        this.message = message;
        this.validator = validator;
    }

    // Method of this Class
    public Boolean call() throws Exception {
        return validator.nullValidator(message);
    }
}
