package com.hr.service.util;

import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppHelper {
    private String encryptionKey = "WDhkduGYusGkqxz";
    
    public String encrypt(String plainText) throws Exception{
        Cipher cipher = getCipher(Cipher.ENCRYPT_MODE);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.encodeBase64String(encryptedBytes);
    }
    
    public String decryt(String encrypted) throws Exception{
        Cipher cipher = getCipher(Cipher.DECRYPT_MODE);
        byte[] plainBytes = cipher.doFinal(Base64.decodeBase64(encrypted));
        return new String(plainBytes);
    }
    
    private Cipher getCipher(int cipherMode) throws Exception{
        String encryptionAlgorithm = "ASE";
        SecretKeySpec keySpecification = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), encryptionAlgorithm);
        Cipher cipher = Cipher.getInstance(encryptionAlgorithm);
        cipher.init(cipherMode, keySpecification);
        return cipher;
    }
}
