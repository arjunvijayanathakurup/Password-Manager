package com.example.passwordmanager;
import org.passay.*;
public class CreatePassword {
CharacterRule alphabets = new CharacterRule(EnglishCharacterData.Alphabetical);
CharacterRule digits = new CharacterRule(EnglishCharacterData.Digit);
CharacterRule special = new CharacterRule(EnglishCharacterData.Special);
PasswordGenerator passwordGenerator = new PasswordGenerator();
String password = passwordGenerator.generatePassword(16,alphabets,digits,special);
}
