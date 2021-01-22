package com.nextinno.unittest.fill.in.zero.each.date;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;

import com.nablecomm.nems.common.service.LocaleService;
import com.nablecomm.nems.common.service.LocaleServiceImpl;

/**
 * <b>기능</b> :
 * <p>
 * nems2.4.x에서 복사해옴. 날짜 및 시간을 시스템으로부터 연산하는 클래스입니다.
 *
 * @author Administrator
 * @since 1.0
 * @see java.util.Date
 */
public class DateUtil {

    public static final int YEAR = 1;
    public static final int MONTH = 2;
    public static final int DATE = 3;
    public static final int MONTHFIRST = 4;
    public static final int MONTHEND = 5;

    /**
     * <p>
     * 현재 날짜와 시각을 yyyyMMdd 형태로 변환 후 return.
     *
     * @param null
     * @return yyyyMMdd
     * 
     *         <pre>
     *  
     *  - 사용 예
     * String date = DateUtil.getYyyymmdd()
     *         </pre>
     */
    public static String getYyyymmdd(Calendar cal) {
        String pattern = "yyyyMMdd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(cal.getTime());
    }

    /**
     * <p>
     * GregorianCalendar 객체를 반환함.
     * 
     * @param yyyymmdd 날짜 인수
     * @return GregorianCalendar
     * @see java.util.Calendar
     * @see java.util.GregorianCalendar
     *      <p>
     * 
     *      <pre>
     *  - 사용 예
     * Calendar cal = DateUtil.getGregorianCalendar(DateUtil.getCurrentYyyymmdd())
     *      </pre>
     */
    public static GregorianCalendar getGregorianCalendar(String yyyymmdd) {

        int yyyy = Integer.parseInt(yyyymmdd.substring(0, 4));
        int mm = Integer.parseInt(yyyymmdd.substring(4, 6));
        int dd = Integer.parseInt(yyyymmdd.substring(6));

        GregorianCalendar calendar = new GregorianCalendar(yyyy, mm - 1, dd, 0, 0, 0);

        return calendar;

    }

    /**
     * <p>
     * GregorianCalendar 객체를 반환함.
     * 
     * @param YYYY-MM-DD H24:MI:SS 날짜 인수
     * @return GregorianCalendar
     * @see java.util.Calendar
     * @see java.util.GregorianCalendar
     *      <p>
     * 
     *      <pre>
     *  - 사용 예
     * Calendar cal = DateUtil.getNableGregorianCalendar("YYYY-MM-DD H24:MI:SS")
     *      </pre>
     */
    public GregorianCalendar getNableGregorianCalendar(String yyyymmdd) {

        int yyyy = Integer.parseInt(yyyymmdd.substring(0, 4));
        int mm = Integer.parseInt(yyyymmdd.substring(5, 7));
        int dd = Integer.parseInt(yyyymmdd.substring(8, 10));
        int hh = Integer.parseInt(yyyymmdd.substring(11, 13));
        int mi = Integer.parseInt(yyyymmdd.substring(14, 16));
        int ss = Integer.parseInt(yyyymmdd.substring(17, 19));

        GregorianCalendar calendar = new GregorianCalendar(yyyy, mm - 1, dd, hh, mi, ss);

        return calendar;

    }

    /**
     * <p>
     * 현재 날짜와 시각을 yyyy-MM-dd hh:mm:ss 형태로 변환 후 return.
     * 
     * @param null
     * @return yyyy-MM-dd hh:mm:ss
     * @see java.util.Date
     * @see java.util.Locale
     *      <p>
     * 
     *      <pre>
     *  
     *  - 사용 예
     * String date = DateUtil.getCurrentDateTime()
     *      </pre>
     */
    public String getCurrentDateTime() {
        Date today = new Date();
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(today);
    }

    /**
     * <p>
     * 현재 날짜와 시각을 yyyyMMdd 형태로 변환 후 return.
     * 
     * @param null
     * @return yyyyMMdd
     * @see java.util.Date
     * @see java.util.Locale
     *      <p>
     * 
     *      <pre>
     *  
     *  - 사용 예
     * String date = DateUtil.getCurrentDateTime()
     *      </pre>
     */
    public String getCurrentDateYyyymmdd() {
        Date today = new Date();
        String pattern = "yyyyMMdd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(today);
    }

    /**
     * <p>
     * 현재 날짜와 시각을 yyyyMMddhhmmss 형태로 변환 후 return.
     * 
     * @param String pattern
     * @return 패턴에 의한 결과
     * @see java.util.Date
     * @see java.util.Locale
     *      <p>
     * 
     *      <pre>
     *  
     *  - 사용 예
     * String date = DateUtil.getCurrentDateTime()
     *      </pre>
     */
    public String getCurrentDateTimePattern(String pattern) {
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(today);
    }

    public String getCurrentDateTimePattern(String pattern, String zoneOffSet) {
        Instant instant = Instant.now();
        ZoneOffset zoneOffset = ZoneOffset.of(zoneOffSet);
        OffsetDateTime odt = OffsetDateTime.ofInstant(instant, zoneOffset);

        return odt.format(DateTimeFormatter.ofPattern(pattern));
    }

    public String getDateTime(Date today) {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(today);
    }

    /**
     * <p>
     * 현재 시각을 hhmmss 형태로 변환 후 return.
     * 
     * @param null
     * @return hhmmss
     * @see java.util.Date
     * @see java.util.Locale
     *      <p>
     * 
     *      <pre>
     *  - 사용 예
     *   String date = DateUtil.getCurrentDateTime()
     *      </pre>
     */
    public static String getCurrentTime() {
        Date today = new Date();
        String pattern = "HHmmss";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(today);

    }

    /**
     * <p>
     * 현재 날짜를 yyyyMMdd 형태로 변환 후 return.
     * 
     * @param null
     * @return yyyyMMdd *
     *         <p>
     * 
     *         <pre>
     *  
     *  - 사용 예
     * String date = DateUtil.getCurrentYyyymmdd()
     *         </pre>
     */
    public String getCurrentYyyymmdd() {
        return getCurrentDateTime().substring(0, 10);
    }

    /**
     * <p>
     * 주로 일자를 구하는 메소드.
     *
     * @param yyyymm 년월
     * @param week 몇번째 주
     * @param pattern 리턴되는 날짜패턴 (ex:yyyyMMdd)
     * @return 연산된 날짜
     * @see java.util.Calendar
     *      <p>
     * 
     *      <pre>
     *  - 사용 예
     * String date = DateUtil.getWeekToDay("200801" , 1, "yyyyMMdd")
     *      </pre>
     */
    @SuppressWarnings("static-access")
    public String getWeekToDay(String yyyymm, int week, String pattern) {

        Calendar cal = Calendar.getInstance();

        int new_yy = Integer.parseInt(yyyymm.substring(0, 4));
        int new_mm = Integer.parseInt(yyyymm.substring(4, 6));
        int new_dd = 1;

        cal.set(new_yy, new_mm - 1, new_dd);

        // 임시 코드
        if (cal.get(cal.DAY_OF_WEEK) == cal.SUNDAY) {
            week = week - 1;
        }

        cal.add(Calendar.DATE, (week - 1) * 7 + (cal.getFirstDayOfWeek() - cal.get(Calendar.DAY_OF_WEEK)));

        SimpleDateFormat formatter = new SimpleDateFormat(pattern);

        return formatter.format(cal.getTime());
    }

    /**
     * <p>
     * 지정된 플래그에 따라 연도 , 월 , 일자를 연산한다.
     *
     * @param field 연산 필드
     * @param amount 더할 수
     * @param date 연산 대상 날짜
     * @return 연산된 날짜
     * @see java.util.Calendar
     *      <p>
     * 
     *      <pre>
     *  - 사용 예
     * String date = DateUtil.getOpDate(java.util.Calendar.DATE , 1, "20080101")
     *      </pre>
     */
    public static String getOpDate(int field, int amount, String date) {

        GregorianCalendar calDate = getGregorianCalendar(date);

        if (field == Calendar.YEAR) {
            calDate.add(GregorianCalendar.YEAR, amount);
        } else if (field == Calendar.MONTH) {
            calDate.add(GregorianCalendar.MONTH, amount);
        } else {
            calDate.add(GregorianCalendar.DATE, amount);
        }

        return getYyyymmdd(calDate);

    }

    /**
     * <p>
     * 입력된 일자를 더한 주를 구하여 return한다
     * 
     * @param yyyymmdd 년도별
     * @param addDay 추가일
     * @return 연산된 주
     * @see java.util.Calendar
     *      <p>
     * 
     *      <pre>
     *  - 사용 예
     * int date = DateUtil.getWeek(DateUtil.getCurrentYyyymmdd() , 0)
     *      </pre>
     */
    public int getWeek(String yyyymmdd, int addDay) {
        Calendar cal = Calendar.getInstance();
        int new_yy = Integer.parseInt(yyyymmdd.substring(0, 4));
        int new_mm = Integer.parseInt(yyyymmdd.substring(4, 6));
        int new_dd = Integer.parseInt(yyyymmdd.substring(6, 8));

        cal.set(new_yy, new_mm - 1, new_dd);
        cal.add(Calendar.DATE, addDay);

        int week = cal.get(Calendar.DAY_OF_WEEK);
        return week;
    }

    /**
     * <p>
     * 입력된 일자를 더한 주를 구하여 return한다
     * 
     * @param yyyymmdd 년도별
     * @param addDay 추가일
     * @return 연산된 주
     * @see java.util.Calendar
     *      <p>
     * 
     *      <pre>
     *  - 사용 예
     * int date = DateUtil.getWeek(DateUtil.getCurrentYyyymmdd() , 0)
     *      </pre>
     */
    public String addDay(String yyyymmdd, int addDay) {
        Calendar cal = Calendar.getInstance();
        int new_yy = Integer.parseInt(yyyymmdd.substring(0, 4));
        int new_mm = Integer.parseInt(yyyymmdd.substring(4, 6));
        int new_dd = Integer.parseInt(yyyymmdd.substring(6, 8));

        cal.set(new_yy, new_mm - 1, new_dd);
        cal.add(Calendar.DATE, addDay);

        java.util.Date sumDate = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String retDate = formatter.format(sumDate);

        return retDate;
    }

    /**
     * <p>
     * 입력된 일자를 더한 주를 구하여 return한다
     * 
     * @param yyyy-mm-dd 년도별
     * @param addDay 추가일
     * @return 연산된 주
     * @see java.util.Calendar
     */
    public String addDayNon(String yyyymmdd, int addDay) {
        Calendar cal = Calendar.getInstance();
        int new_yy = Integer.parseInt(yyyymmdd.substring(0, 4));
        int new_mm = Integer.parseInt(yyyymmdd.substring(5, 7));
        int new_dd = Integer.parseInt(yyyymmdd.substring(8, 10));

        cal.set(new_yy, new_mm - 1, new_dd);
        cal.add(Calendar.DATE, addDay);

        java.util.Date sumDate = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String retDate = formatter.format(sumDate);

        return retDate;
    }

    /**
     * <p>
     * 입력된 일자를 더한 주를 구하여 return한다
     * 
     * @param yyyymmdd 년도별
     * @param addDay 추가일
     * @return 연산된 주
     * @see java.util.Calendar
     *      <p>
     * 
     *      <pre>
     *  - 사용 예
     *      </pre>
     */
    public String addMonth(String yyyymmdd, int addMonth) {
        Calendar cal = Calendar.getInstance();
        int new_yy = Integer.parseInt(yyyymmdd.substring(0, 4));
        int new_mm = Integer.parseInt(yyyymmdd.substring(4, 6));
        int new_dd = Integer.parseInt(yyyymmdd.substring(6, 8));

        cal.set(new_yy, new_mm - 1, new_dd);
        cal.add(Calendar.MONTH, addMonth);

        java.util.Date sumDate = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String retDate = formatter.format(sumDate);

        return retDate;
    }

    public String addMinute(String yyyymmdd, String hhmmss, int addMinute) {
        Calendar cal = Calendar.getInstance();

        int new_yy = Integer.parseInt(yyyymmdd.substring(0, 4));
        int new_mm = Integer.parseInt(yyyymmdd.substring(4, 6));
        int new_dd = Integer.parseInt(yyyymmdd.substring(6, 8));

        int new_hh = Integer.parseInt(hhmmss.substring(0, 2));
        int new_mm1 = Integer.parseInt(hhmmss.substring(2, 4));
        int new_ss = Integer.parseInt(hhmmss.substring(4, 6));

        cal.set(new_yy, new_mm, new_dd, new_hh, new_mm1, new_ss);
        cal.add(Calendar.MINUTE, addMinute);

        java.util.Date sumDate = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        String retTime = formatter.format(sumDate);

        return retTime;
    }

    /**
     * <p>
     * 입력된 년월의 마지막 일수를 return 한다.
     * 
     * @param year
     * @param month
     * @return 마지막 일수
     * @see java.util.Calendar
     *      <p>
     * 
     *      <pre>
     *  - 사용 예
     * int date = DateUtil.getLastDayOfMon(2008 , 1)
     *      </pre>
     */
    public static int getLastDayOfMon(int year, int month) {

        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);

    }// :

    /**
     * <p>
     * 입력된 년월의 마지막 일수를 return한다
     * 
     * @param year
     * @param month
     * @return 마지막 일수
     *         <p>
     * 
     *         <pre>
     *  - 사용 예
     * int date = DateUtil.getLastDayOfMon("2008")
     *         </pre>
     */
    public static int getLastDayOfMon(String yyyymm) {

        Calendar cal = Calendar.getInstance();
        int yyyy = Integer.parseInt(yyyymm.substring(0, 4));
        int mm = Integer.parseInt(yyyymm.substring(4)) - 1;

        cal.set(yyyy, mm, 1);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * <p>
     * 입력된 날자가 올바른지 확인합니다.
     * 
     * @param yyyymmdd
     * @return boolean
     *         <p>
     * 
     *         <pre>
     *  - 사용 예
     * boolean b = DateUtil.isCorrect("20080101")
     *         </pre>
     */
    public static boolean isCorrect(String yyyymmdd) {
        boolean flag = false;
        if (yyyymmdd.length() < 8)
            return false;
        try {
            int yyyy = Integer.parseInt(yyyymmdd.substring(0, 4));
            int mm = Integer.parseInt(yyyymmdd.substring(4, 6));
            int dd = Integer.parseInt(yyyymmdd.substring(6));
            flag = DateUtil.isCorrect(yyyy, mm, dd);
        } catch (Exception ex) {
            return false;
        }
        return flag;
    }// :

    /**
     * <p>
     * 입력된 날자가 올바른 날자인지 확인합니다.
     * 
     * @param yyyy
     * @param mm
     * @param dd
     * @return boolean
     *         <p>
     * 
     *         <pre>
     *  - 사용 예
     * boolean b = DateUtil.isCorrect(2008,1,1)
     *         </pre>
     */
    public static boolean isCorrect(int yyyy, int mm, int dd) {
        if (yyyy < 0 || mm < 0 || dd < 0)
            return false;
        if (mm > 12 || dd > 31)
            return false;

        String year = "" + yyyy;
        String month = "00" + mm;
        String year_str = year + month.substring(month.length() - 2);
        int endday = DateUtil.getLastDayOfMon(year_str);

        if (dd > endday)
            return false;

        return true;

    }// :

    /**
     * <p>
     * 현재 일자를 입력된 type의 날짜로 반환합니다.
     * 
     * @param type
     * @return String
     * @see java.text.DateFormat
     *      <p>
     * 
     *      <pre>
     *  - 사용 예
     * String date = DateUtil.getThisDay("yyyymmddhhmmss")
     *      </pre>
     */
    public String getThisDay(String type) {
        Date date = new Date();
        SimpleDateFormat sdf = null;

        try {
            if (type.toLowerCase().equals("yyyymmdd")) {
                sdf = new SimpleDateFormat("yyyyMMdd");
                return sdf.format(date);
            }
            if (type.toLowerCase().equals("yyyymmddhh")) {
                sdf = new SimpleDateFormat("yyyyMMddHH");
                return sdf.format(date);
            }
            if (type.toLowerCase().equals("yyyymmddhhmm")) {
                sdf = new SimpleDateFormat("yyyyMMddHHmm");
                return sdf.format(date);
            }
            if (type.toLowerCase().equals("yyyymmddhhmmss")) {
                sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                return sdf.format(date);
            }
            if (type.toLowerCase().equals("yyyymmddhhmmssms")) {
                sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
                return sdf.format(date);
            } else {
                sdf = new SimpleDateFormat(type);
                return sdf.format(date);
            }
        } catch (Exception e) {
            return "[ ERROR ]: parameter must be 'YYYYMMDD', 'YYYYMMDDHH', 'YYYYMMDDHHSS'or 'YYYYMMDDHHSSMS'";
        }
    }

    /**
     * <p>
     * 입력된 일자를 '9999년 99월 99일' 형태로 변환하여 반환한다.
     * 
     * @param yyyymmdd
     * @return String
     *         <p>
     * 
     *         <pre>
     *  - 사용 예
     * String date = DateUtil.changeDateFormat("20080101")
     *         </pre>
     */
    public static String changeDateFormat(String yyyymmdd) {
        String rtnDate = null;

        String yyyy = yyyymmdd.substring(0, 4);
        String mm = yyyymmdd.substring(4, 6);
        String dd = yyyymmdd.substring(6, 8);

        LocaleService locale = new LocaleServiceImpl();
        // rtnDate=yyyy+" 년 "+mm + " 월 "+dd + " 일";
        rtnDate = yyyy + " " + locale.translate("SBC.STATS.YEAR") + " " + mm + " " + locale.translate("SBC.STATS.MONTH")
                + " " + dd + " " + locale.translate("COMMON.DAY");

        return rtnDate;

    }

    /**
     * <p>
     * 두 날짜간의 날짜수를 반환(윤년을 감안함)
     * 
     * @param startDate 시작 날짜
     * @param endDate 끝 날짜
     * @return 날수
     * @see java.util.GregorianCalendar
     *      <p>
     * 
     *      <pre>
     *  - 사용 예
     * long date = DateUtil.getDifferDays("20080101","20080202")
     *      </pre>
     */
    public static long getDifferDays(String startDate, String endDate) {

        GregorianCalendar StartDate = getGregorianCalendar(startDate);
        GregorianCalendar EndDate = getGregorianCalendar(endDate);
        long difer = (EndDate.getTime().getTime() - StartDate.getTime().getTime()) / 86400000;
        return difer;

    }

    /**
     * <p>
     * 현재의 요일을 구한다.
     * 
     * @param
     * @return 요일
     * @see java.util.Calendar
     *      <p>
     * 
     *      <pre>
     *  - 사용 예
     * int day = DateUtil.getDayOfWeek()
     *  SUNDAY    = 1
     *  MONDAY    = 2
     *  TUESDAY   = 3
     *  WEDNESDAY = 4
     *  THURSDAY  = 5
     *  FRIDAY    = 6
     *      </pre>
     */
    public static int getDayOfWeek() {
        Calendar rightNow = Calendar.getInstance();
        int day_of_week = rightNow.get(Calendar.DAY_OF_WEEK);
        return day_of_week;
    }

    /**
     * <p>
     * 현재주가 올해 전체의 몇째주에 해당되는지 계산한다.
     * 
     * @param
     * @return 요일
     * @see java.util.Calendar
     *      <p>
     * 
     *      <pre>
     *  - 사용 예
     * int day = DateUtil.getWeekOfYear()
     *      </pre>
     */
    public static int getWeekOfYear() {
        Calendar rightNow = Calendar.getInstance();
        int week_of_year = rightNow.get(Calendar.WEEK_OF_YEAR);
        return week_of_year;
    }

    /**
     * <p>
     * 현재주가 현재월에 몇째주에 해당되는지 계산한다.
     * 
     * @param
     * @return 요일
     * @see java.util.Calendar
     *      <p>
     * 
     *      <pre>
     *  - 사용 예
     * int day = DateUtil.getWeekOfMonth()
     *      </pre>
     */
    public static int getWeekOfMonth() {
        Calendar rightNow = Calendar.getInstance();
        int week_of_month = rightNow.get(Calendar.WEEK_OF_MONTH);
        return week_of_month;
    }

    /**
     * <p>
     * 해당 p_date날짜에 Calendar 객체를 반환함.
     * 
     * @param p_date
     * @return Calendar
     * @see java.util.Calendar
     *      <p>
     * 
     *      <pre>
     *  - 사용 예
     * Calendar cal = DateUtil.getCalendarInstance(DateUtil.getCurrentYyyymmdd())
     *      </pre>
     */
    public static Calendar getCalendarInstance(String p_date) {
        Calendar retCal = Calendar.getInstance();

        if (p_date != null && p_date.length() == 8) {
            int year = Integer.parseInt(p_date.substring(0, 4));
            int month = Integer.parseInt(p_date.substring(4, 6)) - 1;
            int date = Integer.parseInt(p_date.substring(6));

            retCal.set(year, month, date);
        }
        return retCal;
    }

    /**
     * 설명 : 통계에서 DB에 없는 데이터를 '0'으로 채워서 보여주기 위해 구현함
     * 
     * @param startDate : 시작날짜( ex> 2010-12-07 00:00:00)
     * @param endDate : 종료날짜( ex> 2010-12-07 23:59:59)
     * @param dateType : 시간타입(0 : 5분, 5 : 15분, 6 : 30분, 1 : 1시간, 2 : 일간, 4 : 주간, 3 : 월간 7 : 1분)
     * @param columnName : 각 통계에서 필요한 열 이름
     * @return resultData : 해당 기간 동안의 '0' 데이터
     */
    public static ArrayList<LinkedHashMap<String, String>> getGanerateDateAndData(String startDate, String endDate,
            int dateType, ArrayList<String> columnName) {
        LinkedHashMap<String, String> hMap; // HashMap을 생성 후 ArrayList에 담는다
        String pattern = ""; // 날짜 형식 지정
        String colName = "";
        int calendarType = 0; // 시간 타입
        int addTime = 0; // 더할 시간 타임

        ArrayList<LinkedHashMap<String, String>> resultData = new ArrayList<LinkedHashMap<String, String>>();
        Calendar calendar = new GregorianCalendar();
        Calendar endCalendar = new GregorianCalendar(); // 종료 날짜

        // 날짜 및 시간으로 분리
        String[] subStartDate = startDate.split(" "); // 날짜와 시간부분 분리
        String[] subDay = subStartDate[0].split("-"); // 날짜를 년,월,일로 분리
        String[] subTime = subStartDate[1].split(":"); // 시간을 시,분,초로 분리

        String[] subEndDate = endDate.split(" "); // 날짜와 시간부분 분리
        String[] subEndDay = subEndDate[0].split("-"); // 날짜를 년,월,일로 분리
        String[] subEndTime = subEndDate[1].split(":"); // 시간을 시,분,초로 분리

        // 시작 날짜 설정
        calendar.set(Integer.parseInt(subDay[0]), Integer.parseInt(subDay[1]) - 1, Integer.parseInt(subDay[2]),
                Integer.parseInt(subTime[0]), Integer.parseInt(subTime[1]), Integer.parseInt(subTime[2]));

        // 종료 날짜 설정
        endCalendar.set(Integer.parseInt(subEndDay[0]), Integer.parseInt(subEndDay[1]) - 1,
                Integer.parseInt(subEndDay[2]), Integer.parseInt(subEndTime[0]), Integer.parseInt(subEndTime[1]),
                Integer.parseInt(subEndTime[2]));

        // 주간은 별도로 생성한다
        if (dateType == 4) {
            for (int j = 0; j < 7; j++) {
                hMap = new LinkedHashMap<String, String>();
                colName = "";
                // 시간 값 삽입
                hMap.put("DisTime", Integer.toString(j));

                // 컬럼 지정 및 '0'데이터 삽입
                for (int i = 0; i < columnName.size(); i++) {
                    colName = columnName.get(i).toString();

                    if (colName.equals("AVG")) {

                        /*
                         * 평균 값인 경우에는 소수점 2자리로 지정한다. 현재는 사용률 통계에서만 사용하지만 추구 조건을 보강하여 다른 곳에서도 사용하자.
                         */

                        hMap.put(colName, "0.00");
                    } else {

                        hMap.put(colName, "0");
                    }
                }

                resultData.add(hMap);
            }
        } else {
            switch (dateType) {
                case 0: // 5분 통계
                    pattern = "yyyy-MM-dd HH:mm";
                    calendarType = Calendar.MINUTE;
                    addTime = 5;

                    break;

                case 5: // 15분 통계
                    pattern = "yyyy-MM-dd HH:mm";
                    calendarType = Calendar.MINUTE;
                    addTime = 15;

                    break;

                case 6: // 30분 통계
                    pattern = "yyyy-MM-dd HH:mm";
                    calendarType = Calendar.MINUTE;
                    addTime = 30;

                    break;

                case 1: // 1시간 통계
                    pattern = "yyyy-MM-dd HH:mm";
                    calendarType = Calendar.HOUR;
                    addTime = 1;

                    break;

                case 2: // 일간 통계
                    pattern = "yyyy-MM-dd";
                    calendarType = Calendar.DATE;
                    addTime = 1;

                    break;
                case 3: // 월간 통계
                    pattern = "yyyy-MM";
                    calendarType = Calendar.MONTH;
                    addTime = 1;

                    break;
                case 7: // 1분 통계
                    pattern = "yyyy-MM-dd HH:mm";
                    calendarType = Calendar.MINUTE;
                    addTime = 1;

                    break;

                default:
                    break;
            }

            SimpleDateFormat formatter = new SimpleDateFormat(pattern);

            while (calendar.getTimeInMillis() < endCalendar.getTimeInMillis()) {
                hMap = new LinkedHashMap<String, String>();
                colName = "";
                // 시간 값 삽입
                hMap.put("DisTime", formatter.format(calendar.getTime()));

                // 컬럼 지정 및 '0'데이터 삽입
                for (int i = 0; i < columnName.size(); i++) {
                    colName = columnName.get(i).toString();

                    if (colName.equals("AVG")) {

                        /*
                         * 평균 값인 경우에는 소수점 2자리로 지정한다. 현재는 사용률 통계에서만 사용하지만 추구 조건을 보강하여 다른 곳에서도 사용하자.
                         */

                        hMap.put(colName, "0.00");
                    } else {

                        hMap.put(colName, "0");
                    }
                }

                resultData.add(hMap);

                calendar.add(calendarType, addTime); // 30분 더한다
            }
        }

        return resultData;
    }

    /**
     * 설명 : 통계에서 DB에 없는 데이터를 '0'으로 채워서 보여주기 위해 구현함(렐름 통계 전용)
     * 
     * @param startDate : 시작날짜( ex> 2010-12-07 00:00:00)
     * @param endDate : 종료날짜( ex> 2010-12-07 23:59:59)
     * @param dateType : 시간타입(0 : 5분, 5 : 15분, 6 : 30분, 1 : 1시간, 2 : 일간, 4 : 주간, 3 : 월간)
     * @param columnName : 각 통계에서 필요한 열 이름
     * @return resultData : 해당 기간 동안의 '0' 데이터
     */
    public static ArrayList<LinkedHashMap<String, String>> getRealmGanerateDateAndData(String startDate, String endDate,
            int dateType, ArrayList<String> columnName, ArrayList<String> realmName) {
        LinkedHashMap<String, String> hMap; // HashMap을 생성 후 ArrayList에 담는다
        String pattern = ""; // 날짜 형식 지정
        String colName = "";
        int calendarType = 0; // 시간 타입
        int addTime = 0; // 더할 시간 타임

        ArrayList<LinkedHashMap<String, String>> resultData = new ArrayList<LinkedHashMap<String, String>>();
        Calendar calendar = new GregorianCalendar();
        Calendar endCalendar = new GregorianCalendar(); // 종료 날짜

        // 날짜 및 시간으로 분리
        String[] subStartDate = startDate.split(" "); // 날짜와 시간부분 분리
        String[] subDay = subStartDate[0].split("-"); // 날짜를 년,월,일로 분리
        String[] subTime = subStartDate[1].split(":"); // 시간을 시,분,초로 분리

        String[] subEndDate = endDate.split(" "); // 날짜와 시간부분 분리
        String[] subEndDay = subEndDate[0].split("-"); // 날짜를 년,월,일로 분리
        String[] subEndTime = subEndDate[1].split(":"); // 시간을 시,분,초로 분리

        // 시작 날짜 설정
        calendar.set(Integer.parseInt(subDay[0]), Integer.parseInt(subDay[1]) - 1, Integer.parseInt(subDay[2]),
                Integer.parseInt(subTime[0]), Integer.parseInt(subTime[1]), Integer.parseInt(subTime[2]));

        // 종료 날짜 설정
        endCalendar.set(Integer.parseInt(subEndDay[0]), Integer.parseInt(subEndDay[1]) - 1,
                Integer.parseInt(subEndDay[2]), Integer.parseInt(subEndTime[0]), Integer.parseInt(subEndTime[1]),
                Integer.parseInt(subEndTime[2]));

        // 주간은 별도로 생성한다
        if (dateType == 4) {
            // 주간은 0 부터 6까지의 값을 가진다 (sun : 0 ~ Sat : 6 )
            for (int j = 0; j < 7; j++) {
                // 렐름 이름별로 생성
                for (int k = 0; k < realmName.size(); k++) {
                    hMap = new LinkedHashMap<String, String>();
                    colName = "";
                    // 시간 값 삽입
                    hMap.put("DisTime", Integer.toString(j));

                    // 컬럼 지정 및 '0'데이터 삽입
                    for (int i = 0; i < columnName.size(); i++) {
                        colName = columnName.get(i).toString();

                        // 렐름ID 부분에는 렐름 이름을 넣어준다
                        if (colName.equals("realmID")) {
                            hMap.put(colName, realmName.get(k).toString());
                        } else {
                            hMap.put(colName, "0");
                        }
                    }

                    resultData.add(hMap);
                }
            }
        } else {
            switch (dateType) {
                case 0: // 5분 통계
                    pattern = "yyyy-MM-dd HH:mm";
                    calendarType = Calendar.MINUTE;
                    addTime = 5;

                    break;

                case 5: // 15분 통계
                    pattern = "yyyy-MM-dd HH:mm";
                    calendarType = Calendar.MINUTE;
                    addTime = 15;

                    break;

                case 6: // 30분 통계
                    pattern = "yyyy-MM-dd HH:mm";
                    calendarType = Calendar.MINUTE;
                    addTime = 30;

                    break;

                case 1: // 1시간 통계
                    pattern = "yyyy-MM-dd HH:mm";
                    calendarType = Calendar.HOUR;
                    addTime = 1;

                    break;

                case 2: // 일간 통계
                    pattern = "yyyy-MM-dd";
                    calendarType = Calendar.DATE;
                    addTime = 1;

                    break;
                case 3: // 월간 통계
                    pattern = "yyyy-MM";
                    calendarType = Calendar.MONTH;
                    addTime = 1;

                    break;
                case 7: // 1분 통계
                    pattern = "yyyy-MM-dd HH:mm";
                    calendarType = Calendar.MINUTE;
                    addTime = 1;

                    break;
                default:
                    break;
            }

            SimpleDateFormat formatter = new SimpleDateFormat(pattern);

            while (calendar.getTimeInMillis() < endCalendar.getTimeInMillis()) {
                for (int k = 0; k < realmName.size(); k++) {
                    hMap = new LinkedHashMap<String, String>();
                    colName = "";
                    // 시간 값 삽입
                    hMap.put("DisTime", formatter.format(calendar.getTime()));

                    // 컬럼 지정 및 '0'데이터 삽입
                    for (int i = 0; i < columnName.size(); i++) {
                        colName = columnName.get(i).toString();

                        // 렐름ID 부분에는 렐름 이름을 넣어준다
                        if (colName.equals("realmID")) {
                            hMap.put(colName, realmName.get(k).toString());
                        } else {
                            hMap.put(colName, "0");
                        }
                    }

                    resultData.add(hMap);
                }

                calendar.add(calendarType, addTime); // 30분 더한다
            }
        }

        return resultData;
    }

    /**
     * 설 명 : 시간값을 받아서 가공한다. DATE 함수 사용하지 않고 심플하게 만들었다.
     * 
     * @param val : 시간값. ex) '2011-09-01 00:00'
     * @param period : 기간값. ex) 0: 5분, 5: 15분, 6: 30분, 1: 1시간
     * @return ex) 5분간 : '00:00 ~ 0005', 시간 : '09-01 00:00 ~ 01:00'
     */
    public static String timeConversion(String val, String period) {
        String retData = "";
        String hour = "";
        String min = "";

        String[] date;
        String[] day;
        String[] time;

        // [LNE] 5분
        if (period.equals("0")) {
            date = val.split(" ");
            day = date[0].split("-");
            time = date[1].split(":");

            hour = time[0];
            min = time[1];

            retData = hour + ":" + min + " ~ ";

            if (min.equals("55")) {
                hour = Integer.parseInt(hour) + 1 + "";

                if (hour.length() < 2) {
                    hour = "0" + hour;
                }

                min = "00";
            } else {
                min = Integer.parseInt(min) + 5 + "";

                if (min.length() < 2) {
                    min = "0" + min;
                }
            }

            retData = retData + hour + ":" + min;
        }
        // [LNE] 15분
        else if (period.equals("5")) {
            date = val.split(" ");
            day = date[0].split("-");
            time = date[1].split(":");

            hour = time[0];
            min = time[1];

            retData = hour + ":" + min + " ~ ";

            if (min.equals("45")) {
                hour = Integer.parseInt(hour) + 1 + "";

                if (hour.length() < 2) {
                    hour = "0" + hour;
                }

                min = "00";
            } else {
                min = Integer.parseInt(min) + 15 + "";

                if (min.length() < 2) {
                    min = "0" + min;
                }
            }

            retData = retData + hour + ":" + min;
        }
        // [LNE] 30분
        else if (period.equals("6")) {
            date = val.split(" ");
            day = date[0].split("-");
            time = date[1].split(":");

            hour = time[0];
            min = time[1];

            retData = hour + ":" + min + " ~ ";

            if (min.equals("30")) {
                hour = Integer.parseInt(hour) + 1 + "";

                if (hour.length() < 2) {
                    hour = "0" + hour;
                }

                min = "00";
            } else {
                min = Integer.parseInt(min) + 30 + "";

                if (min.length() < 2) {
                    min = "0" + min;
                }
            }

            retData = retData + hour + ":" + min;
        }
        // [LNE] 1시간
        else if (period.equals("1")) {
            date = val.split(" ");
            day = date[0].split("-");
            time = date[1].split(":");

            hour = Integer.parseInt(time[0]) + 1 + "";

            retData = day[1] + "-" + day[2] + " " + time[0] + ":" + time[1] + " ~ ";

            if (hour.length() < 2) {
                hour = "0" + hour;
            }

            retData = retData + hour + ":" + time[1];
        } else {
            retData = val;
        }

        return retData;
    }
}
