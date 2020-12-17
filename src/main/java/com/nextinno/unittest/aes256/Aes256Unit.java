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
     * IV로 암호문을 복호화 하면 된다. 참고로 Key Length와 IV Length는 같아야 하는 것으로 안다. 원문 블록과 IV가 XOR 연산 때문으로 알고 있다..
     * 좀 더 찾아봐야 함.
     * 
     * @param msg
     * @param encrypKey
     * @param strIV
     * @return
     * @throws Exception
     */
    public String encryptAES(String msg, String encrypKey) {
        try {
            byte[] encrypKeyBytes = encrypKey.getBytes();
            if (encrypKeyBytes.length != 32) {
                System.out.println("The AES-256 key must be 32 bytes.");
                return null;
            }

            SecretKeySpec skeySpec = new SecretKeySpec(encrypKeyBytes, AES);

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

            byte[] byteEncrypted = Base64.getEncoder().encode(cipher.doFinal(msg.getBytes()));
            return new String(byteEncrypted, "utf-8");
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
