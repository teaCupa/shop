package org.yh.shop.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Date: 2020/10/24
 * @Description:
 */


public class DateUtil {
    //"2020-09-01" -> Date
     public static Date str2Date(String str,String pattern) {
         Date date = null;
        try {
            //模式必须匹配，否则date为null
            date = new SimpleDateFormat(pattern).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     *
     * @param day  当前日期增加的天数,
     * @return
     */
    public static Date addDay(Integer day){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,day);
        return calendar.getTime();
    }

    public static Date addDay(Date date,Integer day){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,day);
        Date d = calendar.getTime();
//        System.out.println(sdf.format(d));
        return d;
    }

    /**
     * @param date
     * @param n  date起往后连续n个区间
     * @return
     */
    public static List<Date> getDates(Date date, int n){
        List<Date> dates=new ArrayList<>();
        for(int i=0;i<n;i++){
            dates.add(addDayHour(date,2*i));
        }
        return dates;
    }

    /**
     *  时间date加上hour个小时
     * @param date    date
     * @param hour    数字
     * @return
     */
    private static Date addDayHour(Date date,int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR,hour);
        return calendar.getTime();
    }

    /***
     * 获取指定日期的凌晨
     * @return
     */
    public static Date getDayStart(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date start = calendar.getTime();
        return start;
    }

    /**
     * 获取当前时间对应的5个时间区间
     * @return
     */
    public static List<Date> getDateMenus(){
        //全天12个区间 00:00-02:00，... ，22:00-24:00
        List<Date> dates = getDates(getDayStart(new Date()),12);
        Date now =new Date();
        for (Date date : dates) {
            //开始时间<=当前时间<开始时间+2小时
            if(now.getTime()>=date.getTime() && now.getTime()<addDayHour(date,2).getTime()){
                now =date;
                break;
            }
        }
        return getDates(now,5);
    }

    public static void main(String[] args){
//        List<Date> dateMenus = getDateMenus();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
//        for (Date date : dateMenus) {
//            String format = sdf.format(date);
//            System.out.println(format);
//        }
    }


    public static String date2str(Date dateMenu, String format) {
        return new SimpleDateFormat(format).format(dateMenu);
    }
}
