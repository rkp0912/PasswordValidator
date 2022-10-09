package validator;

public class ValidatorImpl implements Validator {
    @Override
    public boolean lengthValidator(String password) throws Exception {
        if(password.length() <= 8)
           throw new Exception("password should be larger than 8 chars");
        else
            return true;
    }

    @Override
    public boolean nullValidator(Object password) throws Exception {
        if(password == null)
            throw  new Exception("password should not be null");
        else
            return true;
    }

    @Override
    public boolean upperCaseValidator(String password) throws Exception {
        boolean hasUpperCase = false;
        nullValidator(password);
        for(int i = 0; i<password.length(); i++){
            char ch = password.charAt(i);
            if(Character.isUpperCase(ch))
                hasUpperCase = true;
        }
        if(hasUpperCase)
            return true;
        else
            throw new Exception("password should have one uppercase letter at least");
    }

    @Override
    public boolean lowerCaseValidator(String password) throws Exception {
        boolean hasLowerCase = false;
        nullValidator(password);
        for(int i = 0; i<password.length(); i++){
            char ch = password.charAt(i);
            if(Character.isLowerCase(ch))
                hasLowerCase = true;
        }
        if(hasLowerCase)
            return true;
        else
            throw new Exception("password should have one uppercase letter at least");
    }
}
