package validator;

public interface Validator {
     boolean lengthValidator(String password) throws Exception;
     boolean nullValidator(Object password) throws Exception;
     boolean upperCaseValidator(String password) throws Exception;
     boolean lowerCaseValidator(String password) throws Exception;
     boolean digitValidator(String password) throws Exception;
}
