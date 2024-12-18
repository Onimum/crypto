package com.example.crypto.entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EncryptRequest {
    private String text;
    private String secretKey;
}
