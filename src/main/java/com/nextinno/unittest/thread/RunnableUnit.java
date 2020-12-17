package com.nextinno.unittest.thread;

import org.springframework.stereotype.Component;

@Component
public class RunnableUnit implements Runnable {
    @Override
    public void run() {
        System.out.println("This code is running in a thread");
    }
}
