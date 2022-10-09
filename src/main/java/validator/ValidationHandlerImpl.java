package validator;

public class ValidationHandlerImpl implements ValidationHandler{
    Validator validator = new ValidatorImpl();
    @Override
    public String validate(Object password) {
        String result = "Password Valid";
        try{
            validator.lengthValidator(password.toString());
            validator.nullValidator(password.toString());
            validator.upperCaseValidator(password.toString());
            validator.lowerCaseValidator(password.toString());
            validator.digitValidator(password.toString());
        }catch (Exception ex){
            //System.out.println(ex.getMessage());
            result = ex.getMessage();
        }

        return result;

    }
}
