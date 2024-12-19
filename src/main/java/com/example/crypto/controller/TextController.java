package com.example.crypto.controller;

import com.example.crypto.service.EncryptionService;
import com.example.crypto.service.DecryptionService;
import com.example.crypto.service.SecretKeyGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/text")
public class TextController {

    private final EncryptionService encryptionService;
    private final DecryptionService decryptionService;

    @GetMapping("/home")
    public String index(Model model) {
        model.addAttribute("activeTab", "encryption");
        return "index";
    }

    @PostMapping("/home")
    public String processText(
        @RequestParam("text") String text,
        @RequestParam("secretKey") String secretKey,
        @RequestParam("algorithm") String algorithm,
        @RequestParam("operation") String operation,
        Model model) {
        try {
            if ("encryption".equalsIgnoreCase(operation)) {
                String encryptedText = encryptionService.encryptText(text, secretKey, algorithm);
                model.addAttribute("resultText", encryptedText);
                model.addAttribute("operation", "encryption");
            } else if ("decryption".equalsIgnoreCase(operation)) {
                String decryptedText = decryptionService.decryptText(text, secretKey,algorithm);
                model.addAttribute("resultText", decryptedText);
                model.addAttribute("operation", "decryption");
            }
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка: " + e.getMessage());
        }
        return "index";
    }

    @GetMapping("/generate-key")
    public String generateKey(@RequestParam int length) {
        try {
            SecretKeyGenerator keyGenerator = new SecretKeyGenerator();
            return keyGenerator.generateKey(length);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка генерации ключа: " + e.getMessage(), e);
        }
    }

}
