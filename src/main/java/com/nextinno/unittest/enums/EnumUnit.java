package com.nextinno.unittest.enums;

import org.springframework.stereotype.Component;

@Component
public class EnumUnit {
    enum Level {
        LOW, MEDIUM, HIGH
    }

    public void excuteEnum() {
        Level myVar = Level.MEDIUM;
        // 아래와 같이 바로 사용해도 value로 사용가능하고. toString()을 붙여 String으로 사용도 가능하다.
        System.out.println(myVar);

        switch (myVar) {
            case LOW:
                System.out.println("Low level");
                break;
            case MEDIUM:
                System.out.println("Medium level");
                break;
            case HIGH:
                System.out.println("High level");
                break;
        }

        for (Level tempVar : Level.values()) {
            System.out.println(tempVar);
            System.out.println(tempVar.toString());
        }
    }
}
