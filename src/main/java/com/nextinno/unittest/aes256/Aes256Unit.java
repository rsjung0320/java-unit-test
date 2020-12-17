package com.nextinno.unittest.aes256;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

/**
 * @author rsjung 2020. 12. 17.
 */
@Component
public class Aes256Unit {

    private final String AES = "AES";

    /**
     * Cipher Mode가 ECB이다. 추후 CBC로 바뀌면 IV가 필요하다. 그런대 IV는 매번 랜덤 값으로 넣어야 한다. 참조.
     * https://en.wikipedia.org/wiki/Block_cipher_mode_of_operation#Initialization_vector_(IV) 그래서
     * 암호화 할 때 IV를 랜덤으로 생성하고, 암호화 문 앞 혹은 뒤에 붙인다. 복호화 할 때는 앞 혹은 뒤에서 IV의 길이만큼 subString 한 후 secretKey와
     * IV로 암호문을 복호화 하면 된다. 참고로 IV Length는 16이어야 한다. 블럭은 16 바이트 이기 때문이다. AES256도 실제로는 128을 두개로 나뉘서 하는
     * 것이다. 좀 더 찾아봐야 함.
     * 
     * @param msg
     * @param encrypKey
     * @param strIV
     * @return
     * @throws Exception
     */
    public String encryptAES256(String msg, String secretKey) {
        try {
            byte[] secretKeyBytes = secretKey.getBytes();

            if (secretKeyBytes.length != 32) {
                System.out.println("The AES-256 key must be 32 bytes.");
                return null;
            }

            SecretKeySpec skeySpec = new SecretKeySpec(secretKeyBytes, AES);

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

            byte[] byteEncrypted = Base64.getEncoder().encode(cipher.doFinal(msg.getBytes()));
            return new String(byteEncrypted, "utf-8");
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String decryptAES256(String cipherText, String secretKey) {
        try {
            byte[] secretKeyBytes = secretKey.getBytes();

            if (secretKeyBytes.length != 32) {
                System.out.println("The AES-256 key must be 32 bytes.");
                return null;
            }

            SecretKeySpec skeySpec = new SecretKeySpec(secretKeyBytes, AES);

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);

            byte[] byteDecrypted = Base64.getDecoder().decode(cipherText.getBytes());
            return new String(cipher.doFinal(byteDecrypted), "utf-8");
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
