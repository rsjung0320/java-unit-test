package com.nextinno.unittest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nextinno.unittest.bytecheck.ByteCheckUnit;
import com.nextinno.unittest.enums.EnumUnit;
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

    public static void main(String[] args) {
        SpringApplication.run(UnittestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // unit_Thread();
        // unit_enum();
        unit_byteCheck();
    }

    private void unit_byteCheck() {
        byteCheckUnit.excuteByteCheckUnit();
    }

    private void unit_enum() {
        enumUnit.excuteEnum();
    }

    private void unit_Thread() {
        threadUnit.start();
        System.out.println("This code is outside of the thread");

        // Runnable 은 아래와 같이 구동해야 함
        Thread thread = new Thread(runnableUnit);
        thread.start();
    }
}
