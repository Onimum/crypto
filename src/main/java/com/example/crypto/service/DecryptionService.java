package com.example.crypto.service;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Service
public class DecryptionService {

    public String decryptText(String encryptedText, String key, String algorithm) throws Exception {
        if ("AES".equalsIgnoreCase(algorithm)) {
            key = formatKey(key, 16);
            algorithm = "AES/ECB/PKCS5Padding";
        } else if ("DES".equalsIgnoreCase(algorithm)) {
            key = formatKey(key, 8);
            algorithm = "DES/ECB/PKCS5Padding";
        } else {
            throw new IllegalArgumentException("Unsupported algorithm: " + algorithm);
        }

        Cipher cipher = Cipher.getInstance(algorithm);
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), algorithm.split("/")[0]);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    private String formatKey(String key, int length) {
        if (key.length() < length) {
            return String.format("%-" + length + "s", key).replace(' ', '0');
        } else {
            return key.substring(0, length);
        }
    }
}

