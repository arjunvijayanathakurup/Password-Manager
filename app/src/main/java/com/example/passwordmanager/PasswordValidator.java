package com.example.passwordmanager;
import org.passay.*;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {


    public String Validator(String userpassword)
    {
        List<Rule> rules = new ArrayList<>();
        //Defining the first rule of password length

        rules.add(new LengthRule(16,16));
        //Rule checking for at least one  Uppercase

        rules.add(new CharacterRule(EnglishCharacterData.UpperCase,1));

        //Rule checking for at least one  lowercase
        rules.add(new CharacterRule(EnglishCharacterData.LowerCase,1));
        //Rule to check for whitespaces
        rules.add(new WhitespaceRule());
        //Rule to check for numbers
        rules.add(new CharacterRule(EnglishCharacterData.Digit,1));
        //Rule to check for special characters
        rules.add(new CharacterRule(EnglishCharacterData.Special,1));
        org.passay.PasswordValidator validator = new org.passay.PasswordValidator(rules);
        PasswordData password = new PasswordData(userpassword);
        RuleResult resut = validator.validate(password);
        if(resut.isValid())
        {
            return "Password Validated";
        }
        else
            return "Invalid Password "+validator.getMessages(resut);

    }



}
