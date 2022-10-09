package validator;

public class ValidatorImpl implements Validator {
    @Override
    public boolean lengthValidator(String password) throws Exception {
        if(password.length() <= 8)
           throw new Exception("password should be larger than 8 chars");
        else
            return true;
    }
}
