package com.example.crypto.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DecryptRequest {
    private String encryptedText;
    private String secretKey;
}
