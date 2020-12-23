package com.nextinno.unittest;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nextinno.unittest.aes256.Aes256Unit;
import com.nextinno.unittest.aspect.RsaUtil;
import com.nextinno.unittest.bytecheck.ByteCheckUnit;
import com.nextinno.unittest.enums.EnumUnit;
import com.nextinno.unittest.splitcheck.SplitCheckUnit;
import com.nextinno.unittest.thread.RunnableUnit;
import com.nextinno.unittest.thread.ThreadUnit;

@SpringBootApplication
public class UnittestApplication implements CommandLineRunner {
    @Autowired
    private ThreadUnit threadUnit;
    @Autowired
    private RunnableUnit runnableUnit;
    @Autowired
    private EnumUnit enumUnit;
    @Autowired
    private ByteCheckUnit byteCheckUnit;
    @Autowired
    private Aes256Unit aes256Unit;
    @Autowired
    private SplitCheckUnit splitCheckUnit;
    @Autowired
    private RsaUtil rsaUtil;

    public static void main(String[] args) {
        SpringApplication.run(UnittestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        unit_rsa();
        // unit_splitcheck();
        // unit_Thread();
        // unit_enum();
        // unit_byteCheck();
        // unit_Aes256();
        // unit_Aes256_CBC();
    }

    private void unit_rsa() {
        PublicKey publicKey = rsaUtil.StringToPublicKey(Base64.getDecoder()
                .decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCs2TS5x35FzYeJBi1DGl2YNWJnln3HuNpjdbpByaz3js4vqfxHa6hhVuyQUQWLDeM3y9XdayIzBVJmRdvnD1xkLV06zGu0wblsD0OwG3zw1FgtnTKdIDy5FtFpGH7tU+dalnp/7dP1pps3tO2qCfW4F2PkRffMxuaNU6IDuPM9RwIDAQAB"
                        .getBytes()));
        PrivateKey privateKey = rsaUtil.StringToPrivateKey(Base64.getDecoder()
                .decode("MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKzZNLnHfkXNh4kGLUMaXZg1YmeWfce42mN1ukHJrPeOzi+p/EdrqGFW7JBRBYsN4zfL1d1rIjMFUmZF2+cPXGQtXTrMa7TBuWwPQ7AbfPDUWC2dMp0gPLkW0WkYfu1T51qWen/t0/Wmmze07aoJ9bgXY+RF98zG5o1TogO48z1HAgMBAAECgYANFjz5u/MBkfgrFb6jkAF6HsCemzRWxNY0JZu+k2h3LebKkRI6zhnnlM9AdgH3b0u+074Tj6L9Pe/pMmzd57nU88r7G7OmRMAaiGEohF7GrMSyHKyZLCTy0Anmm8im4xbivBQrjjx5agZLX0Ak5IFxWkQMUW7E4ZjkFLVzv03SwQJBAO2pQt2miHF9urwaqzVh4eu+FvEHlRYkntkmbBlFwwQgmFy8Q8C/+icsClc+Jpt8pnSM6tX5InDNG63XdWK9jxECQQC6L6PNZxIVgI2zjNrtXXR3Ibr5apnM5lF/JzBLuJAq84y59FKLzLM+PKXomLPKmV9ztynbj1A81L1nzTcbarbXAkEAoxiIUbIKatAcySAIJH9C2lQ+TDSm5GZHOMB8aK+OUJPJ28I7QNi+ZAl+Izb8qbHWTZ+zPRpWv1CS0S9OWG+78QJAShsOIoJE02Qggnes589LvOMjDYUdhE2j4G1Trr/eOgpIV/dkJ5qpOTtgeczVuu0C7gbYVTicoim23arzpSj7bwJBAM4Wn6K3eFUuOLZrVrplXe+oH/1/AE/2BBbNmBJSyDJxsNbhmgFF7L8NFiapW/Ppak+sxp6U64rZA7b8BjrmXzg="
                        .getBytes()));

        // for (int i = 0; i < 100; i++) {
        // String encrypted = rsaUtil.encryptRSA("test", publicKey);
        // System.out.println(" encrypted : " + encrypted);
        // String decrypted = rsaUtil.decryptRSA(encrypted, privateKey);
        // System.out.println(" decrypted : " + decrypted);
        // }

        String plainText = "test";
        String encrypted = rsaUtil.encryptRSA(plainText, publicKey);
        System.out.println("encrypted : " + encrypted);

        int count = 0;
        for (int i = 0; i < 100000; i++) {
            if (encrypted.equals(rsaUtil.encryptRSA(plainText, publicKey)))
                count++;
        }
        System.out.println("count : " + count);
    }

    private void unit_splitcheck() {
        splitCheckUnit.excuteSplitCheck();
    }

    private void unit_Thread() {
        threadUnit.start();
        System.out.println("This code is outside of the thread");

        // Runnable 은 아래와 같이 구동해야 함
        Thread thread = new Thread(runnableUnit);
        thread.start();
    }

    private void unit_Aes256_CBC() {
        String cipherText = aes256Unit.encryptAes256Cbc("test", "f3c5d432705191627778e4683d87dfed");
        System.out.println(cipherText);
        String Text = aes256Unit.decryptAes256Cbc(cipherText, "f3c5d432705191627778e4683d87dfed");
        System.out.println(Text);
    }

    private void unit_Aes256() {
        String cipherText = aes256Unit.encryptAES256("test", "f3c5d432705191627778e4683d87dfed");
        System.out.println(cipherText);
        String Text = aes256Unit.decryptAES256(cipherText, "f3c5d432705191627778e4683d87dfed");
        System.out.println(Text);
    }

    private void unit_byteCheck() {
        byteCheckUnit.excuteByteCheckUnit();
    }

    private void unit_enum() {
        enumUnit.excuteEnum();
    }

}
