package com.nextinno.unittest.aspect;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rsjung 2020. 11. 20.
 */
@Component
@Slf4j
public class RsaUtil {
    private final String RSA = "RSA";

    /**
     * Public Key로 RAS 암호화를 수행합니다.
     * 
     * @param plainText 암호화 할 평문 입니다.
     * @param publicKey
     * @return
     */
    public String encryptRSA(String plainText, PublicKey publicKey) {
        Cipher cipher;
        try {
            cipher = Cipher.getInstance(RSA);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] bytePlain = cipher.doFinal(plainText.getBytes());
            return Base64.getEncoder().encodeToString(bytePlain);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
                | BadPaddingException e) {
            log.error("encryptRSA Exception :", e);
            return null;
        }
    }

    /**
     * Private Key로 RAS 복호화를 수행합니다.
     * 
     * @param encrypted 암호화된 이진데이터를 base64 인코딩한 문자열 입니다.
     * @param privateKey 복호화를 위한 개인키 입니다.
     * @return
     * @throws Exception
     */
    public String decryptRSA(String encrypted, PrivateKey privateKey) {
        Cipher cipher;
        try {
            cipher = Cipher.getInstance(RSA);
            byte[] byteEncrypted = Base64.getDecoder().decode(encrypted.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] bytePlain = cipher.doFinal(byteEncrypted);
            return new String(bytePlain, "utf-8");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | UnsupportedEncodingException
                | IllegalBlockSizeException | BadPaddingException e) {
            log.error("decryptRSA Exception :", e);
            return null;
        }
    }

    /**
     * byte[]으로 된 key를 PublicKey 로 반환하는 함수
     * 
     * @param publicKeyStr
     * @return
     */
    public PublicKey StringToPublicKey(byte[] publicKeyStr) {
        KeyFactory keyFactory = null;
        PublicKey publicKey = null;
        try {
            X509EncodedKeySpec ukeySpec = new X509EncodedKeySpec(publicKeyStr);
            keyFactory = KeyFactory.getInstance(RSA);
            publicKey = keyFactory.generatePublic(ukeySpec);
        } catch (Exception e) {
            log.error("StringToPublicKey Exception : ", e);
        }

        return publicKey;
    }

    /**
     * byte[]으로 된 key를 PrivateKey 로 반환하는 함수
     * 
     * @param privateKeyStr
     * @return
     */
    public PrivateKey StringToPrivateKey(byte[] privateKeyStr) {
        PrivateKey privateKey = null;
        KeyFactory keyFactory = null;
        try {
            PKCS8EncodedKeySpec rkeySpec = new PKCS8EncodedKeySpec(privateKeyStr);
            keyFactory = KeyFactory.getInstance(RSA);
            privateKey = keyFactory.generatePrivate(rkeySpec);
        } catch (Exception e) {
            log.error("StringToPrivateKey Exception : ", e);
        }
        return privateKey;
    }

    /**
     * hex로 된 key를 byte[]로 변환
     * 
     * @param hex
     * @return
     */
    public byte[] hexToByteArray(String hex) {
        if (hex == null || hex.length() == 0) {
            return null;
        }
        byte[] ba = new byte[hex.length() / 2];
        for (int i = 0; i < ba.length; i++) {
            ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return ba;
    }

    /**
     * key를 String으로 변환
     * 
     * @param ba
     * @return
     */
    public String byteArrayToHex(byte[] ba) {
        if (ba == null || ba.length == 0) {
            return null;
        }

        StringBuffer sb = new StringBuffer(ba.length * 2);
        String hexNumber = "";

        for (int x = 0; x < ba.length; x++) {
            hexNumber = "0" + Integer.toHexString(0xff & ba[x]);
            sb.append(hexNumber.substring(hexNumber.length() - 2));
        }
        return sb.toString();
    }
}
