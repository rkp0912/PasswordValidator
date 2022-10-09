package validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorImplTest {
    ValidatorImpl validatorImpl = new ValidatorImpl();
    @Test
    @DisplayName("Password length must be larger than 8 characters")
    void lengthValidationSuccess() throws Exception {
       boolean actual = validatorImpl.lengthValidator("Password1");
        Assertions.assertTrue(actual);
    }
    @Test
    @DisplayName("Should throw exception on password length less than 8 characters")
    void lengthValidationFailure(){
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            validatorImpl.lengthValidator("Passwor");
        });
        assertTrue(exception.getMessage().contentEquals("password should be larger than 8 chars"));
    }

    @Test
    @DisplayName("Password should not be null")
    void nullValidationSuccess() throws Exception{
        boolean actual = validatorImpl.nullValidator("Password");
        Assertions.assertTrue(actual);
    }

    @Test
    @DisplayName("Should throw exception if password is null")
    void nullValidationFailure(){
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            validatorImpl.nullValidator(null);
        });
        assertTrue(exception.getMessage().contentEquals("password should not be null"));
    }

    @Test
    @DisplayName("Password should contain atleast one upper case character")
    void upperCaseValidationSuccess() throws Exception{
        boolean actual = validatorImpl.upperCaseValidator("Password1");
        Assertions.assertTrue(actual);
    }

    @Test
    @DisplayName("Should throw exception if password does not contain upper case character")
    void upperCaseValidationFailure(){
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            validatorImpl.upperCaseValidator("password1");
        });
        assertTrue(exception.getMessage().contentEquals("password should have one uppercase letter at least"));
    }

    @Test
    @DisplayName("Should throw exception if password is null")
    void upperCaseValidationFailureWithNull(){
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            validatorImpl.upperCaseValidator(null);
        });
        assertTrue(exception.getMessage().contentEquals("password should not be null"));
    }

}