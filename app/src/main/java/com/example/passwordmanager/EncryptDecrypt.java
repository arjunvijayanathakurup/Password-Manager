package com.example.passwordmanager;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptDecrypt {
    //Class to Encrypt and Decrypt the user passwords.
    //We will be using AES

    //The two main functions that we will be calling in MainActivity
    //decrypt(decryptvalue,key)  both parameters are string.
    //encrypt(encryptvalue,key) both parameters are string.

    private static SecretKeySpec secretKey;
    //We need a secret key to encrypt and decrypt
    private static byte[] key;

    public static void setKey(String myKey)
    {
        //This methord is for the key generation. We won't be calling this methord outside this class.
        MessageDigest sha=null;
        try
        {
            key = myKey.getBytes("UTF-8");
            //We need to change string to bytes
            sha = MessageDigest.getInstance("SHA-1");
            //We will be using sha-1 hex digest.
            key = sha.digest(key);
            //storing the sha digest in key.
            key = Arrays.copyOf(key,16);
            //Define the length of key as byte.
            secretKey = new SecretKeySpec(key,"AES");
            //Defining the algorithm and key to be used.

        }
        catch(NoSuchAlgorithmException e)   //Exception
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) //Exception
        {
            e.printStackTrace();
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String encrypt(String strToEncrypt, String secret)
    {
        //Method to encrypt the password.
        try
        {
            setKey(secret);   //This will be our key.
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            //We will be using AES using CBC and PKCS5 for padding.
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            //Encryption.
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
            //return the encrypted passsword in a string format.
        }
        catch (Exception e) //Exception.
        {
            return "Error while encrypting "+e.toString();
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String decrypt(String strToDecrypt, String secret)
    {
        //Decryption
        try  //Repeating the same process in the encryption.
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,secretKey);
            //Changing the mode to Decrypt for decryption.
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
            //returning the password.

        }
        catch (Exception e) //Exception.
        {
            return "Error while decrypting: " +e.toString();
        }
    }
}
