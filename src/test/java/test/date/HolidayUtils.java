package test.date;

import com.google.common.collect.Lists;
import org.apache.http.client.utils.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by tianxiang on 2020/10/14
 */
public class HolidayUtils {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * 获取计划激活日期
     * @param today opening date
     * @param holidayList holidayList
     * @param num num个工作日后
     * @return
     * @throws ParseException
     */
    public static Date getScheduleActiveDate(Date today, List<String> holidayList, List<String> extraWorkdayList, int num) throws ParseException {
        int delay = 1;
        while(delay <= num){
            Date tomorrow = getTomorrow(today);
            String tomorrowStr = sdf.format(tomorrow);
            //当前日期+1,判断是否是节假日,不是的同时要判断是否是周末,都不是则scheduleActiveDate日期+1
            if((!isWeekend(tomorrowStr) && !isHoliday(tomorrowStr,holidayList))
                    || isExtraWorkdays(tomorrowStr,extraWorkdayList)){
                delay++;
                today = tomorrow;
            } else if (isWeekend(tomorrowStr)){
                today = tomorrow;
            } else if (isHoliday(tomorrowStr,holidayList)){
                today = tomorrow;
            }
        }

        return today;
    }

    /**
     * 获取tomorrow的日期
     *
     * @param date
     * @return
     */
    public static Date getTomorrow(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        date = calendar.getTime();
        return date;
    }

    /**
     * 判断是否是weekend
     *
     * @param sdate
     * @return
     * @throws ParseException
     */
    public static boolean isWeekend(String sdate) throws ParseException {
        Date date = sdf.parse(sdate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
            return true;
        } else{
            return false;
        }

    }

    /**
     * 判断是否是holiday
     *
     * @param sdate
     * @param list
     * @return
     * @throws ParseException
     */
    public static boolean isHoliday(String sdate, List<String> list) throws ParseException {
        if(list.size() > 0){
            for(int i = 0; i < list.size(); i++){
                if(sdate.equals(list.get(i))){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是否是由于放假需要额外工作的周末
     *
     * @param sdate
     * @param list
     * @return
     * @throws ParseException
     */
    public static boolean isExtraWorkdays(String sdate, List<String> list) throws ParseException {
        if(list.size() > 0){
            for(int i = 0; i < list.size(); i++){
                if(sdate.equals(list.get(i))){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)throws Exception {
        // 法定节假日(需要定时入库再读库，政府每年都会在12月份左右公布，无法提前预知)
        List holidayList = Lists.newArrayList();
        holidayList.add("2020-10-01");
        holidayList.add("2020-10-02");
        holidayList.add("2020-10-03");
        holidayList.add("2020-10-04");
        holidayList.add("2020-10-05");
        holidayList.add("2020-10-06");
        holidayList.add("2020-10-07");

        // 额外工作日(需要补班的日期)
        List extraWorkdayList = Lists.newArrayList();
        extraWorkdayList.add("2020-10-10");

        String[] dateFormats = new String[1];
        dateFormats[0] = "yyyy-MM-dd";
        Date date = DateUtils.parseDate("2020-10-09", dateFormats);
        System.out.println(HolidayUtils.getScheduleActiveDate(date, holidayList,extraWorkdayList, 2));
    }
}

