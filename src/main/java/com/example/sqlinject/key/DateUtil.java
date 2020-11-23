package com.example.sqlinject.key;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public DateUtil()
    {
    }

    /**
     *
     * <pre>
     * DB에 저장하는 기본 14자 시간정보 "yyyyMMddHHmmss"
     * </pre>
     * <pre>
     * <b>Parameters:</b>
     * ▶
     * ▶
     * </pre>
     * <pre>
     * <b>Returns:</b>
     *
     * </pre>
     * @author HJKIM
     */
    public String getDate()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date currentdate = new Date();
        return formatter.format(currentdate);
    }

    /**
     *
     * <pre>
     * 현재 시간에 입력값(초) 만큼 시간을 더하여 리턴
     * </pre>
     * <pre>
     * <b>Parameters:</b>
     * ▶
     * ▶
     * </pre>
     * <pre>
     * <b>Returns:</b>
     *
     * </pre>
     * @author HJKIM
     */
    public String getShiftedDate(long shiftSecs)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date shiftdate = new Date();
        shiftdate.setTime(System.currentTimeMillis() + shiftSecs * 1000);
        return formatter.format(shiftdate);
    }

    /**
     *
     * <pre>
     * 현재 년월일정보  "yyyyMMdd"
     * </pre>
     * <pre>
     * <b>Parameters:</b>
     * ▶
     * ▶
     * </pre>
     * <pre>
     * <b>Returns:</b>
     *
     * </pre>
     * @author HJKIM
     */
    public String getDay()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date currentdate = new Date();
        return formatter.format(currentdate);
    }

    /**
     *
     * <pre>
     * 현재 년월정보  "yyyyMM"
     * </pre>
     * <pre>
     * <b>Parameters:</b>
     * ▶
     * ▶
     * </pre>
     * <pre>
     * <b>Returns:</b>
     *
     * </pre>
     * @author HJKIM
     */
    public String getMonth()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
        Date currentdate = new Date();
        return formatter.format(currentdate);
    }


    /**
     * <pre>
     * 년월일문자열 정보를 구분자로 분리후 합쳐 리턴한다.
     * </pre>
     * <pre>
     * <b>Parameters:</b>
     * ▶  Date String : 년월일 문자열 EX) 20150629
     * ▶  Separator : 년월일을 나누는 구분자 EX) . / -
     * </pre>
     * <pre>
     * <b>Returns:</b>
     *  EX) 2015/06/29
     * </pre>
     * @author HJKIM
     */
    public String date(String str, String separator)
    {
        String temp = null;
        if(str == null)
            return "";
        int len = str.length();
        if(len != 8)
            return str;
        if(str.equals("00000000") || str.equals("       0") || str.equals("        "))
        {
            return "";
        } else
        {
            temp = str.substring(0, 4) + separator + str.substring(4, 6) + separator + str.substring(6, 8);
            return temp;
        }
    }

    /**
     * <pre>
     * 년월일문자열 정보를 구분자로 분리후 합쳐 리턴한다.
     * </pre>
     * <pre>
     * <b>Parameters:</b>
     * ▶  Date String : 년월일 문자열 EX) 150629
     * ▶  Separator : 년월일을 나누는 구분자 EX) . / -
     * </pre>
     * <pre>
     * <b>Returns:</b>
     *  EX) 15/06/29
     * </pre>
     * @author HJKIM
     */
    public String date2(String str, String separator)
    {
        String temp = null;
        if(str == null)
            return "";
        int len = str.length();
        if(len != 6)
            return str;
        if(str.equals("000000") || str.equals("     0"))
        {
            return "";
        } else
        {
            temp = str.substring(0, 2) + separator + str.substring(2, 4) + separator + str.substring(4, 6);
            return temp;
        }
    }


    /**
     * <pre>
     * 년월일문자열 정보를 '.'로  분리후 합쳐 리턴한다.
     * </pre>
     * <pre>
     * <b>Parameters:</b>
     * ▶  Date String : 년월일 문자열 EX) 20150629
     * ▶
     * </pre>
     * <pre>
     * <b>Returns:</b>
     *  EX) 2015.06.29
     * </pre>
     * @author HJKIM
     */
    public String dotDate(String str)
    {
        String temp = null;
        if(str == null)
            return "";
        int len = str.length();
        if(len != 8)
            return str;
        if(str.equals("00000000") || str.equals("       0"))
        {
            return "";
        } else
        {
            temp = str.substring(0, 4) + "." + str.substring(4, 6) + "." + str.substring(6, 8);
            return temp;
        }
    }


    public String getSimpleStringTimeFormat(long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        return formatter.format(new Date(time));
    }

    /**
     * <br> 특정 시간과 지금 시간의 차이 절대값을 초로 반환한다. <br>
     * <p><pre>
     * <b>파라미터 설정.</b>
     * ▶ date 시간
     * ▶
     * </pre></p>
     *
     *
     * @paramminute
     */
    public Long getDateGapSecond(String dateTime) {
        return Math.abs(getDateDiffSecond(dateTime));
    }

    /**
     * <br> 특정 시간과 지금 시간의 차이를  초로 반환한다. <br>
     * <p><pre>
     * <b>파라미터 설정.</b>
     * ▶ date 시간
     * ▶
     * </pre></p>
     *
     *
     * @paramminute
     */
    public Long getDateDiffSecond(String dateTime) {
        String currentDate =  getSimpleStringTimeFormat(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        try {
            cal1.setTime(formatter.parse(currentDate));
            cal2.setTime(formatter.parse(dateTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long lr = cal1.getTimeInMillis() - cal2.getTimeInMillis();
        long second = lr/1000;  //통합 초

        return second;
    }

}
