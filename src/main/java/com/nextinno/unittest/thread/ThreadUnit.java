package com.nextinno.unittest.thread;

import org.springframework.stereotype.Component;

@Component
public class ThreadUnit extends Thread {

    public void run() {
        System.out.println("This code is running in a thread");
    }
}
