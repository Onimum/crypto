package com.example.crypto.service;

import java.security.SecureRandom;
import java.util.Base64;

public class SecretKeyGenerator {
  public String generateKey(int length) {
    SecureRandom random = new SecureRandom();
    byte[] key = new byte[length];
    random.nextBytes(key);
    return Base64.getEncoder().encodeToString(key);
  }

}
