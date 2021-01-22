package com.nextinno.unittest.fill.in.zero.each.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FillInZeroEachDate {
    public String fillInZeroEachDate(String startDate, String endDate, int unitTime) {
        try {
            switch (unitTime) {
                case 0: // 1분 단위
                    /*
                     * DATE_FORMAT( DTIME, '%Y-%m-%d %H:%i' ) 2021-01-21 21:47
                     */
                    String[] strArray = getDateByDay(startDate, endDate);
                    break;
                case 1: // 5분 단위
                    break;
                case 2: // 15분 단위
                    break;
                case 3: // 30분 단위
                    break;
                case 4: // 1시간 단위
                    break;
                case 5: // 1일 단위
                    break;
                case 6: // 주 단위
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    // 시작~ 종료시간을 Date 형으로 우선 구한다.
                    Date start;

                    start = df.parse(startDate);

                    Calendar tempDate = Calendar.getInstance();
                    tempDate.setTime(start);
                    System.out.println(getDayOfTheWeek(tempDate));
                    break;
                case 7: // 월 단위
                    break;
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private String[] getDateByDay(String startDate, String endDate) {

        return null;
    }

    private String getDayOfTheWeek(Calendar cls) {

        int nowDays = cls.get(Calendar.DAY_OF_WEEK);
        String date = null;

        switch (nowDays) {
            case 1:
                date = "SUN";
                break;
            case 2:
                date = "MON";
                break;
            case 3:
                date = "TUE";
                break;
            case 4:
                date = "WED";
                break;
            case 5:
                date = "THU";
                break;
            case 6:
                date = "FRI";
                break;
            case 7:
                date = "SAT";
                break;
        }
        return date;
    }
}
