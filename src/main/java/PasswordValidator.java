import validator.ValidationHandler;
import validator.ValidationHandlerImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PasswordValidator {
    public static void main(String[] args)  {
        ValidationHandler validationHandler = new ValidationHandlerImpl();
        System.out.println("Welcome to Password Validator");
        System.out.println("Enter 0 (zero) to quit");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = "";
        while(!name.equals("0")) {
            System.out.println("\nEnter Password to Validate :");
            try {
                name = reader.readLine();
            }catch (Exception e){
                System.out.println(e);
            }
            if(!name.equals("0"))
                System.out.println(validationHandler.validate(name));
        }
    }
}
