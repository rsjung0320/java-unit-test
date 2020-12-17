package com.nextinno.unittest.splitcheck;

import org.springframework.stereotype.Component;

@Component
public class SplitCheckUnit {
    public void excuteSplitCheck() {
        String filePath = "/nable/nems/nems3.0.0/conf/goldfish.conf";
        String[] fileName = filePath.split("/");
        if (fileName[fileName.length - 1].equals("goldfish.conf")) {
            try {
                Thread.sleep(5000);
                if (fileName[fileName.length - 1].equals("goldfish.conf")) {
                    System.out.println(fileName[fileName.length - 1]);
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}
