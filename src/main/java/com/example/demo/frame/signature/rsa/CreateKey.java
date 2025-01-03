package com.example.demo.frame.signature.rsa;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

/**
 * @Author Nanaan
 * @Date 2024/10/12 16:45
 * @Description 生成RSA公私钥，并保存到本地
 */
public class CreateKey {
    public static void main(String[] args) throws Exception {
        //密钥算法
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        //密钥长度
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //获取公私钥
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        //公私钥转换为Base64编码
        String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        String privateKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        //保存公私钥文件到本应用根目录下
        Files.write(Paths.get("pub_key.pem"), publicKeyString.getBytes());
        Files.write(Paths.get("pri_key.pem"), privateKeyString.getBytes());
    }
}
