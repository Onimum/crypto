package com.example.crypto.controller;


import com.example.crypto.entity.DecryptRequest;
import com.example.crypto.entity.EncryptRequest;
import com.example.crypto.service.EncryptionService;
import com.example.crypto.service.DecryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/text")
public class TextController {

    @Autowired
    private EncryptionService encryptionService;

    @Autowired
    private DecryptionService decryptionService;

    @PostMapping("/encrypt")
    public String encryptText(@RequestBody EncryptRequest request) {
        try {
            return encryptionService.encryptText(request.getText(), request.getSecretKey());
        } catch (Exception e) {
            throw new RuntimeException("Ошибка шифрования текста", e);
        }
    }

    @PostMapping("/decrypt")
    public String decryptText(@RequestBody DecryptRequest request) {
        try {
            return decryptionService.decryptText(request.getEncryptedText(), request.getSecretKey());
        } catch (Exception e) {
            throw new RuntimeException("Ошибка дешифрования текста", e);
        }
    }
}
