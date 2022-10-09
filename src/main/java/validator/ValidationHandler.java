package validator;

public interface ValidationHandler {
    String validate(Object password);
    String validate(Object password, int numOfSuccessfulValidations);
}
