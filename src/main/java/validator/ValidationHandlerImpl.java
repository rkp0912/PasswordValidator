package validator;

import java.util.concurrent.*;

public class ValidationHandlerImpl implements ValidationHandler {
    Validator validator = new ValidatorImpl();

    @Override
    public String validate(Object password) {
        String result = "Password Valid";
        try {
            validator.lengthValidator(password.toString());
            validator.nullValidator(password.toString());
            validator.upperCaseValidator(password.toString());
            validator.lowerCaseValidator(password.toString());
            validator.digitValidator(password.toString());
        } catch (Exception ex) {
            result = ex.getMessage();
        }

        return result;
    }

    @Override
    public String validate(Object password, int numOfSuccessfulValidations) {
        StringBuffer result = new StringBuffer();
        result.append("Password Valid");
        StringBuffer errorMessage = new StringBuffer();
        errorMessage.append("Password Invalid:\n");
        Integer countOfSuccessfulValidations = 0;
        try{
            mandatoryValidation(password.toString());
            countOfSuccessfulValidations++;
        }catch (Exception ex){
           return errorMessage.append(ex.getMessage()).toString();
        }

        NullValidatorTask nullTask = new NullValidatorTask(password.toString());
        UpperCaseValidatorTask upperCaseTask = new UpperCaseValidatorTask(password.toString());
        LowerCaseValidatorTask lowerCaseTask = new LowerCaseValidatorTask(password.toString());
        DigitValidatorTask digitCaseTask = new DigitValidatorTask(password.toString());
        ExecutorService executorService
                = Executors.newFixedThreadPool(4);
        Future<Boolean> nullValidation
                = executorService.submit(nullTask);
        Future<Boolean> upperCaseValidation
                = executorService.submit(upperCaseTask);
        Future<Boolean> lowerCaseValidation
                = executorService.submit(lowerCaseTask);
        Future<Boolean> digitValidation
                = executorService.submit(digitCaseTask);

        try{
            nullValidation.get();
            countOfSuccessfulValidations++;
        }catch (Exception ex){
            errorMessage.append(ex.getMessage().split(":")[1].trim()+"\n");
        }

        try{
           upperCaseValidation.get();
           countOfSuccessfulValidations++;
        }catch (Exception ex){
            errorMessage.append(ex.getMessage().split(":")[1].trim()+"\n");
        }

        try{
           lowerCaseValidation.get();
           countOfSuccessfulValidations++;
        }catch (Exception ex){
            errorMessage.append(ex.getMessage().split(":")[1].trim()+"\n");
        }

        try{
            digitValidation.get();
            countOfSuccessfulValidations++;
        }catch (Exception ex){
            errorMessage.append(ex.getMessage().split(":")[1].trim());
        }

        executorService.shutdown();

        if(countOfSuccessfulValidations >= numOfSuccessfulValidations)
            return result.toString();
        else
            return errorMessage.toString();
    }

    private boolean mandatoryValidation(Object password) throws Exception {
        return validator.lengthValidator(password.toString());
    }

    class NullValidatorTask implements Callable<Boolean> {
        // Member variable of this class
        private String message;

        // Constructor of this class
        public NullValidatorTask(String message) {
            // This keyword refers to current instance itself
            this.message = message;
        }

        // Method of this Class
        public Boolean call() throws Exception {
          return validator.nullValidator(message);

        }
    }

    class UpperCaseValidatorTask implements Callable<Boolean> {
        // Member variable of this class
        private String message;

        // Constructor of this class
        public UpperCaseValidatorTask(String message) {
            // This keyword refers to current instance itself
            this.message = message;
        }

        // Method of this Class
        public Boolean call() throws Exception {
            try{
                return validator.upperCaseValidator(message);
            }catch (Exception ex){
                throw ex;
            }
        }
    }

    class LowerCaseValidatorTask implements Callable<Boolean> {
        // Member variable of this class
        private String message;

        // Constructor of this class
        public LowerCaseValidatorTask(String message) {
            // This keyword refers to current instance itself
            this.message = message;
        }

        // Method of this Class
        public Boolean call() throws Exception {
            return validator.lowerCaseValidator(message);

        }
    }

    class DigitValidatorTask implements Callable<Boolean> {
        // Member variable of this class
        private String message;

        // Constructor of this class
        public DigitValidatorTask(String message) {
            // This keyword refers to current instance itself
            this.message = message;
        }

        // Method of this Class
        public Boolean call() throws Exception {
            return validator.digitValidator(message);

        }
    }
}