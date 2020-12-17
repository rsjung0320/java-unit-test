package com.nextinno.unittest.bytecheck;

import org.springframework.stereotype.Component;

@Component
public class ByteCheckUnit {
    public void excuteByteCheckUnit() {
        byte[] length = "test".getBytes();
        System.out.println(length.length + "바이트");

        byte[] length1 = "hello world".getBytes();
        System.out.println(length1.length + "바이트");
    }
}
