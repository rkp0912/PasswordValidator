package validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationHandlerImplTest {
    ValidationHandler validationHandler = new ValidationHandlerImpl();

    @Test
    @DisplayName("Password validation successful")
    void validateHandlerSuccessful() {
        String actual = validationHandler.validate("Password1");
        Assertions.assertTrue(actual.contentEquals("Password Valid"));
    }

    @Test
    @DisplayName("Password validation should fail due to missing uppercase")
    void validateHandlerFailureWithUpperCase(){
        String actual =  validationHandler.validate("password1");
        Assertions.assertTrue(actual.contentEquals("password should have one uppercase letter at least"));
    }

    @Test
    @DisplayName("Password validation should fail due to missing lowercase")
    void validateHandlerFailureWithLowerCase(){
        String actual =  validationHandler.validate("PASSWORD1");
        Assertions.assertTrue(actual.contentEquals("password should have one lowercase letter at least"));
    }

    @Test
    @DisplayName("Password validation should fail due to missing digit")
    void validateHandlerFailureWithDigit(){
        String actual =  validationHandler.validate("Passwordd");
        Assertions.assertTrue(actual.contentEquals("password should have one number at least"));
    }
}