package com.nextinno.unittest.trythrow;

import org.springframework.stereotype.Component;

@Component
public class ThrowUtil {
    public String excuteThrow() throws ServiceException {

        // try {
        System.out.println("try");
        throw new ServiceException("error", 400);
        // } catch (Exception e) {
        // System.out.println("Exception");
        // throw new ServiceException("error", 400);
        // } finally {
        // // try 던 catch 던 구동되고 finally는 무조건 탄다.
        // System.out.println("finally");
        // return "success";
        // }
    }
}
