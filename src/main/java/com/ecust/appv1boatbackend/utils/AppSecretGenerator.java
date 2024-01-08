package com.ecust.appv1boatbackend.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class AppSecretGenerator {

    public static String generateAppSecret() {
        try {
            // 生成随机的字节数组作为密钥
            byte[] randomBytes = new byte[32];
            new SecureRandom().nextBytes(randomBytes);

            // 使用SHA-256进行哈希处理
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(randomBytes);

            // 将字节数组转换为Base64编码的字符串
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to generate app secret", e);
        }
    }

    public static void main(String[] args) {
        String appSecret = generateAppSecret();
        System.out.println("Generated App Secret: " + appSecret);
    }
}
