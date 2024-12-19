package com.example.crypto.controller;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Controller
@RequestMapping("api/files/upload")
public class FileController {

  @RequestMapping
  public String uploadPage() {
    return "upload";
  }

  @PostMapping
  public String analyzeFileMetadata(@RequestParam("file") MultipartFile file, Model model) {
    try (InputStream inputStream = file.getInputStream()) {
      // Используем Apache Tika для анализа
      Metadata metadata = new Metadata();
      BodyContentHandler handler = new BodyContentHandler();
      AutoDetectParser parser = new AutoDetectParser();

      parser.parse(inputStream, handler, metadata);

      model.addAttribute("fileName", file.getOriginalFilename());
      model.addAttribute("metadata", metadata);
      return "metadata-result";
    } catch (Exception e) {
      model.addAttribute("error", "Ошибка при анализе файла: " + e.getMessage());
      return "error";
    }
  }
}