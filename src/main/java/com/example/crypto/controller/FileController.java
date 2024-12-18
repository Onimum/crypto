//package com.example.crypto.controller;
//import com.example.crypto.service.DecryptionService;
//import com.example.crypto.service.EncryptionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.InputStreamResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.crypto.SecretKey;
//import java.io.ByteArrayInputStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//@RestController
//@RequestMapping("/api/file")
//public class FileController {
//
//    @Autowired
//    private EncryptionService encryptionService;
//
//    @Autowired
//    private DecryptionService decryptionService;
//
////    @PostMapping("/upload")
////    public byte[] uploadFile(@RequestParam("file") MultipartFile file, @RequestParam SecretKey secretKey) throws Exception {
////        // Преобразуем имя файла в Path для использования в методе шифрования
////        Path filePath = Paths.get(file.getOriginalFilename());
////
////        return encryptionService.encryptFile(filePath, secretKey);
////    }
//
//    @PostMapping("/decrypt")
//    public ResponseEntity<InputStreamResource> decryptFile(@RequestParam("file") MultipartFile file, @RequestParam SecretKey secretKey) throws Exception {
//        byte[] encryptedData = file.getBytes();
//        byte[] decryptedData = decryptionService.decryptFile(encryptedData, secretKey);
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getOriginalFilename() + "\"")
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(new InputStreamResource(new ByteArrayInputStream(decryptedData)));
//    }
//}
