package com.example.crypto.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DecryptRequest {
    @NotBlank(message = "Text cannot be empty")
    private String encryptedText;
    @Size(min = 20, max = 20, message = "Key must be 20 characters long")
    private String secretKey;
}
