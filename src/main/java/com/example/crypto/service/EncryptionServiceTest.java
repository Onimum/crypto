//package com.example.crypto.service;
//import org.junit.Test;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//
//import javax.crypto.SecretKey;
//import java.nio.file.Files;
//import java.nio.file.Path;
//
//public class EncryptionServiceTest {
//
//    @Autowired
//    private EncryptionService encryptionService;
//
//    @Autowired
//    private DecryptionService decryptionService;
//
//    @Test
//    public void testEncryptDecryptText() throws Exception {
//        SecretKey secretKey = encryptionService.generateSecretKey();
//        String plainText = "Hello, World!";
//        String encryptedText = encryptionService.encryptText(plainText, secretKey);
//        String decryptedText = decryptionService.decryptText(encryptedText, secretKey);
//
//        assertEquals(plainText, decryptedText);
//    }
//
//    @Test
//    public void testEncryptDecryptFile() throws Exception {
//        SecretKey secretKey = encryptionService.generateSecretKey();
//        Path filePath = Path.of("path/to/your/test/file.txt");
//        byte[] encryptedData = encryptionService.encryptFile(filePath, secretKey);
//        byte[] decryptedData = decryptionService.decryptFile(encryptedData, secretKey);
//
//        assertTrue(Files.exists(Path.of("path/to/your/decrypted/file.txt")));
//    }
//}
