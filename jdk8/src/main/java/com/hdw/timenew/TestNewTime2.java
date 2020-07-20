package com.hdw.timenew;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/**
 * @author hdw
 * @create 2020-06-23-14:31
 * @desc 描述
 *
 * DateTimeFormatter 格式化时间/日期
 */
public class TestNewTime2 {

    /**
     * DateTimeFormatter 格式化时间/日期
     */
    @Test
    public void  test(){
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime now=LocalDateTime.now();
        String format1 = now.format(dtf);

        System.out.println(format1);
        System.out.println("---------------------");

        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String f3 = f2.format(now);
        System.out.println(f3);

        LocalDateTime parse = now.parse(f3, f2);
        System.out.println(parse);

    }

    /**
     * 时区操作
     * zoneDate zoneTime zoneDateTime
     */
    @Test
    public void  test1(){
        //全部时区
        Set <String> ids = ZoneId.getAvailableZoneIds();
        ids.forEach(System.out::println);
    }

    /**
     * 时区操作
     * zoneDate zoneTime zoneDateTime
     */
    @Test
    public void  test2(){
        //指定时区的时间
        LocalDateTime now=LocalDateTime.now(ZoneId.of("Europe/London"));
        System.out.println(now);
        System.out.println("--------------------------");
        //带时区的时间
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("Europe/London"));
        System.out.println(zonedDateTime);
    }

}
