package com.nextinno.unittest;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nextinno.unittest.aes256.Aes256Unit;
import com.nextinno.unittest.aspect.RsaUtil;
import com.nextinno.unittest.bytecheck.ByteCheckUnit;
import com.nextinno.unittest.enums.EnumUnit;
import com.nextinno.unittest.fill.in.zero.each.date.DateUtil;
import com.nextinno.unittest.fill.in.zero.each.date.FillInZeroEachDate;
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
    @Autowired
    private FillInZeroEachDate fillInZeroEachDate;
    @Autowired
    private DateUtil dateUtil;

    public static void main(String[] args) {
        SpringApplication.run(UnittestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        unit_fill();
        // unit_rsa();
        // unit_splitcheck();
        // unit_Thread();
        // unit_enum();
        // unit_byteCheck();
        // unit_Aes256();
        // unit_Aes256_CBC();
    }

    private void unit_fill() {
        ArrayList<String> strArray = new ArrayList<String>();
        // { cTime: '2021-01-12 04:00', req: '0', resSuccess: '1', resInteract: '0', resFull: '0' }
        strArray.add("cTime");
        strArray.add("req");
        strArray.add("resSuccess");
        strArray.add("resInteract");
        strArray.add("resFull");

        ArrayList<LinkedHashMap<String, String>> fakeData_1min =
                dateUtil.getGanerateDateAndData("2020-02-01 00:00:00", "2020-02-01 01:59:59", 7, strArray);
        ArrayList<LinkedHashMap<String, String>> fakeData_5min =
                dateUtil.getGanerateDateAndData("2020-02-01 00:00:00", "2020-02-01 01:59:59", 0, strArray);
        ArrayList<LinkedHashMap<String, String>> fakeData_15min =
                dateUtil.getGanerateDateAndData("2020-02-01 00:00:00", "2020-02-01 02:59:59", 5, strArray);
        ArrayList<LinkedHashMap<String, String>> fakeData_30min =
                dateUtil.getGanerateDateAndData("2020-02-01 00:00:00", "2020-02-01 05:59:59", 6, strArray);
        ArrayList<LinkedHashMap<String, String>> fakeData_1hour =
                dateUtil.getGanerateDateAndData("2020-02-01 00:00:00", "2020-02-01 12:59:59", 1, strArray);
        ArrayList<LinkedHashMap<String, String>> fakeData_day =
                dateUtil.getGanerateDateAndData("2020-02-01 00:00:00", "2020-02-07 23:59:59", 2, strArray);
        ArrayList<LinkedHashMap<String, String>> fakeData_week =
                dateUtil.getGanerateDateAndData("2020-02-01 00:00:00", "2020-02-07 23:59:59", 4, strArray);
        ArrayList<LinkedHashMap<String, String>> fakeData_month =
                dateUtil.getGanerateDateAndData("2020-01-01 00:00:00", "2020-12-31 23:59:59", 3, strArray);
        System.out.println("fakeData_1min :" + fakeData_1min.toString());
        System.out.println("fakeData_5min :" + fakeData_5min.toString());
        System.out.println("fakeData_15min :" + fakeData_15min.toString());
        System.out.println("fakeData_30min :" + fakeData_30min.toString());
        System.out.println("fakeData_1hour :" + fakeData_1hour.toString());
        System.out.println("fakeData_day :" + fakeData_day.toString());
        System.out.println("fakeData_week :" + fakeData_week.toString());
        System.out.println("fakeData_month :" + fakeData_month.toString());
        /*
         * 0 = DATE_FORMAT( DTIME, '%Y-%m-%d %H:%i' ) 2021-01-21 21:47 1 = DATE_FORMAT( DATE_SUB(
         * DTIME, INTERVAL MINUTE( DTIME ) MOD 5 MINUTE ), '%Y-%m-%d %H:%i' ) AS cTime 2021-01-21
         * 21:45 2 = DATE_FORMAT( DATE_SUB( DTIME, INTERVAL MINUTE( DTIME ) MOD 15 MINUTE
         * ),'%Y-%m-%d %H:%i' ) AS cTime 2021-01-21 21:45 3 = DATE_FORMAT( DATE_SUB( DTIME, INTERVAL
         * MINUTE( DTIME ) MOD 30 MINUTE ),'%Y-%m-%d %H:%i' ) AS cTime 2021-01-21 21:30 4 =
         * DATE_FORMAT( DTIME, '%Y-%m-%d %H:00' ) AS cTime 2021-01-21 21:00 5 = DATE_FORMAT( DTIME,
         * '%Y-%m-%d' ) AS cTime 2021-01-21 6 = CASE WHEN DATE_FORMAT(DTIME, '%w') = 0 THEN CONCAT(
         * 'SUN', ' (', DATE_FORMAT(DTIME, '%m-%d'), ')' ) WHEN DATE_FORMAT(DTIME, '%w') = 1 THEN
         * CONCAT( 'MON', ' (', DATE_FORMAT(DTIME, '%m-%d'), ')' ) WHEN DATE_FORMAT(DTIME, '%w') = 2
         * THEN CONCAT( 'TUE', ' (', DATE_FORMAT(DTIME, '%m-%d'), ')' ) WHEN DATE_FORMAT(DTIME,
         * '%w') = 3 THEN CONCAT( 'WED', ' (', DATE_FORMAT(DTIME, '%m-%d'), ')' ) WHEN
         * DATE_FORMAT(DTIME, '%w') = 4 THEN CONCAT( 'THU', ' (', DATE_FORMAT(DTIME, '%m-%d'), ')' )
         * WHEN DATE_FORMAT(DTIME, '%w') = 5 THEN CONCAT( 'FRI', ' (', DATE_FORMAT(DTIME, '%m-%d'),
         * ')' ) WHEN DATE_FORMAT(DTIME, '%w') = 6 THEN CONCAT( 'SAT', ' (', DATE_FORMAT(DTIME,
         * '%m-%d'), ')' ) ELSE '-' END AS cTime THU (01-21) 7 = DATE_FORMAT( DTIME, '%Y-%m' ) AS
         * cTime 2021-01
         */
    }

    private void unit_rsa() {
        PublicKey publicKey = rsaUtil.StringToPublicKey(
                "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCs2TS5x35FzYeJBi1DGl2YNWJnln3HuNpjdbpByaz3js4vqfxHa6hhVuyQUQWLDeM3y9XdayIzBVJmRdvnD1xkLV06zGu0wblsD0OwG3zw1FgtnTKdIDy5FtFpGH7tU+dalnp/7dP1pps3tO2qCfW4F2PkRffMxuaNU6IDuPM9RwIDAQAB");
        PrivateKey privateKey = rsaUtil.StringToPrivateKey(
                "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKzZNLnHfkXNh4kGLUMaXZg1YmeWfce42mN1ukHJrPeOzi+p/EdrqGFW7JBRBYsN4zfL1d1rIjMFUmZF2+cPXGQtXTrMa7TBuWwPQ7AbfPDUWC2dMp0gPLkW0WkYfu1T51qWen/t0/Wmmze07aoJ9bgXY+RF98zG5o1TogO48z1HAgMBAAECgYANFjz5u/MBkfgrFb6jkAF6HsCemzRWxNY0JZu+k2h3LebKkRI6zhnnlM9AdgH3b0u+074Tj6L9Pe/pMmzd57nU88r7G7OmRMAaiGEohF7GrMSyHKyZLCTy0Anmm8im4xbivBQrjjx5agZLX0Ak5IFxWkQMUW7E4ZjkFLVzv03SwQJBAO2pQt2miHF9urwaqzVh4eu+FvEHlRYkntkmbBlFwwQgmFy8Q8C/+icsClc+Jpt8pnSM6tX5InDNG63XdWK9jxECQQC6L6PNZxIVgI2zjNrtXXR3Ibr5apnM5lF/JzBLuJAq84y59FKLzLM+PKXomLPKmV9ztynbj1A81L1nzTcbarbXAkEAoxiIUbIKatAcySAIJH9C2lQ+TDSm5GZHOMB8aK+OUJPJ28I7QNi+ZAl+Izb8qbHWTZ+zPRpWv1CS0S9OWG+78QJAShsOIoJE02Qggnes589LvOMjDYUdhE2j4G1Trr/eOgpIV/dkJ5qpOTtgeczVuu0C7gbYVTicoim23arzpSj7bwJBAM4Wn6K3eFUuOLZrVrplXe+oH/1/AE/2BBbNmBJSyDJxsNbhmgFF7L8NFiapW/Ppak+sxp6U64rZA7b8BjrmXzg=");

        String plainText = "test";

        String encrypted = rsaUtil.encryptRSA(plainText, publicKey);
        System.out.println(" encrypted : " + encrypted);
        String decrypted = rsaUtil.decryptRSA(encrypted, privateKey);
        System.out.println(" decrypted : " + decrypted);

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
