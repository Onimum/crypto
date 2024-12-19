package com.example.crypto.entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EncryptRequest {
    @NotBlank(message = "Text cannot be empty")
    private String text;
    @Size(min = 16, max = 16, message = "Key must be 16 characters long")
    private String secretKey;
    private String algorithm;
}


