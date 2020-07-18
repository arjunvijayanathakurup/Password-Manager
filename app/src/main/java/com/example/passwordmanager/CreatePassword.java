package com.example.passwordmanager;
import org.passay.*;
public class CreatePassword {

    public String createpassword() {
//Methord to create password.

        CharacterRule alphabets = new CharacterRule(EnglishCharacterData.Alphabetical);   //Alphabets

        CharacterRule digits = new CharacterRule(EnglishCharacterData.Digit);   //Digits

        CharacterRule special = new CharacterRule(EnglishCharacterData.Special); //Special characters

        PasswordGenerator passwordGenerator = new PasswordGenerator();

        String password = passwordGenerator.generatePassword(16, alphabets, digits, special);  //Password generation.

        return password;
    }

}
