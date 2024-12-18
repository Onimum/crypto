//package com.example.crypto.controller;
//import com.example.crypto.entity.EncryptRequest;
//import com.example.crypto.service.DecryptionService;
//import com.example.crypto.service.EncryptionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.crypto.SecretKey;
//
//@RestController
//@RequestMapping("/api/network")
//public class NetworkController {
//
//    @Autowired
//    private EncryptionService encryptionService;
//
//    @Autowired
//    private DecryptionService decryptionService;
//
//    @PostMapping("/encrypt")
//    public String encryptText(@RequestBody EncryptRequest request) {
//        try {
//            String text = request.getText();
//            String secretKey = request.getSecretKey();
//
//            if (text == null || secretKey == null) {
//                throw new IllegalArgumentException("Both 'text' and 'secretKey' are required fields.");
//            }
//
//            return encryptionService.encryptText(text, secretKey);
//        } catch (Exception e) {
//            throw new RuntimeException("Ошибка шифрования текста", e);
//        }
//    }
//
//
//    @RestController
//    @RequestMapping("/api/data")
//    public class DataController {
//
//        private final DecryptionService decryptionService;
//
//        public DataController(DecryptionService decryptionService) {
//            this.decryptionService = decryptionService;
//        }
//
//        @PostMapping("/receive")
//        public String receiveDecryptedData(@RequestParam String encryptedData, @RequestParam SecretKey secretKey) {
//            try {
//                return decryptionService.decryptText(encryptedData, secretKey);
//            } catch (Exception e) {
//                throw new RuntimeException("Ошибка расшифрования данных", e);
//            }
//        }
//    }
//
//}
