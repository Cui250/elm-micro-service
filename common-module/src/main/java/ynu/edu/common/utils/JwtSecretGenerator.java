package ynu.edu.common.utils;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

public class JwtSecretGenerator {
    public static void main(String[] args) {
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        String encodedKey = java.util.Base64.getEncoder().encodeToString(secretKey.getEncoded());
        System.out.println("JWT Secret (Base64 Encoded):");
        System.out.println(encodedKey);
    }
}