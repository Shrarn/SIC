package com.shrarn.healdeck;

import android.util.Base64;

import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class DataEncryption
{
    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpec ks;
    private SecretKeyFactory skf;
    private Cipher cipher;
    byte[] arrayBytes;
    private String myEncryptionKey;
    private String myEncryptionScheme;
    SecretKey key;

    public DataEncryption() throws Exception
    {
        myEncryptionKey="CodingIsFun,EncryptionIsSafe";
        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
        arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        ks = new DESedeKeySpec(arrayBytes);
        skf = SecretKeyFactory.getInstance(myEncryptionScheme);
        cipher = Cipher.getInstance(myEncryptionScheme);
        key=skf.generateSecret(ks);
    }

    public String encrypt(String unencryptedString) throws Exception
    {
        String encryptedString = null;
        try
        {
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            encryptedString = new String(Base64.encode(encryptedText,1));

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return encryptedString;
    }


    public String decrypt(String encryptedString)
    {
        String decryptedText=null;
        try
        {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.decode(encryptedString,1);
            byte[] plainText = cipher.doFinal(encryptedText);
            decryptedText = new String(plainText);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return decryptedText;
    }
}
