package validator;

public interface Validator {
     boolean lengthValidator(String password) throws Exception;
     boolean nullValidator(Object password) throws Exception;
     boolean upperCaseValidator(String password) throws Exception;
}
