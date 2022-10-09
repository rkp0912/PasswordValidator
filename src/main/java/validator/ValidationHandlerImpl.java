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
            validator.lengthValidator(password.toString());
            countOfSuccessfulValidations++;
        }catch (Exception ex){
            errorMessage.append(ex.getMessage()+"\n");
        }

        try{
            validator.nullValidator(password.toString());
            countOfSuccessfulValidations++;
        }catch (Exception ex){
            errorMessage.append(ex.getMessage()+"\n");
        }


        try{
            validator.upperCaseValidator(password.toString());
            countOfSuccessfulValidations++;
        }catch (Exception ex){
            errorMessage.append(ex.getMessage()+"\n");
        }

        try{
            validator.lowerCaseValidator(password.toString());
            countOfSuccessfulValidations++;
        }catch (Exception ex){
            errorMessage.append(ex.getMessage()+"\n");
        }

        try{
            validator.digitValidator(password.toString());
            countOfSuccessfulValidations++;
        }catch (Exception ex){
            errorMessage.append(ex.getMessage());
        }

        if(countOfSuccessfulValidations >= numOfSuccessfulValidations)
            return result.toString();
        else
            return errorMessage.toString();

    }
}
