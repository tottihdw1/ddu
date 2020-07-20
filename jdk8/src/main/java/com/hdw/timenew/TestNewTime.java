package com.hdw.timenew;

import org.junit.Test;

import java.time.*;

/**
 * @author hdw
 * @create 2020-06-23-11:04
 * @desc 描述
 *
 * 本地时间与时间戳
 */
public class TestNewTime {
    /**
     * 使用LocalDate
     * 使用LocalTime
     * 使用LocalDateTime
     * 不可变对象，提供（ISO-8601）简单的日期和时间，并不包含当前的时间信息，也不包含时区信息
     *
     */
    @Test
    public void test(){
        LocalDateTime lt=LocalDateTime.now();
        System.out.println(lt);
        LocalDateTime ldt = LocalDateTime.of(2020, 06, 15, 11, 12, 30);
        System.out.println(ldt);

        System.out.println(lt.plusYears(1));
        System.out.println(lt.minusMonths(2));

        System.out.println(lt.getHour());
        System.out.println(lt.getSecond());


    }

    /**
     * Instant: 时间戳 (以unix元年：1970年1月1日00：00:00 到某个时间之间的毫秒值)
     *
     */
    @Test
    public void test1(){
        Instant now = Instant.now();//默认获取UTC时区
        System.out.println(now);

        //8个时区
        OffsetDateTime ourDate = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(ourDate);
        //时间戳
        System.out.println(now.toEpochMilli());
        //增加一秒
        Instant d1 = Instant.ofEpochSecond(1);
        System.out.println(d1);


    }

    /**
     * Duration  计算两个“时间”之间的间隔
     * Period    计算两个“日期”之间的间隔
     *
     */
    @Test
    public void test2() throws InterruptedException {
        Instant d1= Instant.now();
        LocalTime ld1=LocalTime.now();
        Thread.sleep(1000);
        Instant d2=Instant.now();
        LocalTime ld2=LocalTime.now();

        System.out.println(Duration.between(d1, d2).toMillis());
        System.out.println(Duration.between(ld1, ld2).toMillis());
        System.out.println("-----------------------------------------");

        LocalDate now1=LocalDate.of(2016,1,1);
        LocalDate now2=LocalDate.now();

        System.out.println(Period.between(now1, now2).getYears());


    }
}
