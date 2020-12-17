package com.nextinno.unittest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nextinno.unittest.aes256.Aes256Unit;
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

    public static void main(String[] args) {
        SpringApplication.run(UnittestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        unit_splitcheck();
        // unit_Thread();
        // unit_enum();
        // unit_byteCheck();
        // unit_Aes256();
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
