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
    void lengthValidationFailure() throws Exception {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            validatorImpl.lengthValidator("Passwor");
        });
        assertTrue(exception.getMessage().contentEquals("password should be larger than 8 chars"));
    }
}