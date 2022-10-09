# Password Validator
This Password Validator project is for validating the passwords. This is a maven project.
This password validator checks for

1. password should be larger than 8 chars
2. password should not be null
3. password should have one uppercase letter at least
4. password should have one lowercase letter at least
5. password should have one number at least

Along with below constraints
1. Password is "Valid" if at least three of the previous conditions is true
2. Password is never Valid if password length is less than or equal to 8 characters.



### How to build
    mvn clean install

### How to run unit tests
    mvn test

### How to execute
When project is built using "mvn clean install", a jar file with name
PasswordValidator-1.0-SNAPSHOT.jar under "target" of the project directory.
you can run the jar using

    java -jar PasswordValidator-1.0-SNAPSHOT.jar

following lines will be printed on the screen

Welcome to Password Validator
Enter 0 (zero) to quit

Enter Password to Validate :


### Sample Output

    Welcome to Password Validator
    Enter 0 (zero) to quit
    
    Enter Password to Validate :
    @#$%^&*&^
    Password Invalid:                                 
    password should have one uppercase letter at least
    password should have one lowercase letter at least
    password should have one number at least
    
    Enter Password to Validate :
    Password1
    Password Valid
    
    Enter Password to Validate :
    0



