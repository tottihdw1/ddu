package com.hdw.timenew;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @author hdw
 * @create 2020-06-23-14:01
 * @desc 描述
 *
 * TemporalAdjuster 时间校正器，有时候我们需要获取例如，将日期调整到下个周日等操作
 * TemporalAdjusters 该类通过静态方法，提供了大量常用的TemporalAdjuster实现。
 */
public class TestNewTime1 {


    /**
     * TemporalAdjuster 时间校正器
     */
    @Test
    public void test(){
        LocalDateTime ldt1=LocalDateTime.now();
        LocalDateTime ldt2 = ldt1.withDayOfMonth(10);
        System.out.println(ldt1);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt1.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);

        //自定义下一个工作日
        LocalDateTime ldt5 = ldt1.with((d) -> {
            LocalDateTime ldt4 = (LocalDateTime) d;
            DayOfWeek dayOfWeek = ldt4.getDayOfWeek();
            switch (dayOfWeek) {
                case FRIDAY:
                    return ldt4.plusDays(3);
                case SATURDAY:
                    return ldt4.plusDays(2);
                default:
                    return ldt4.plusDays(1);
            }

        });
        System.out.println(ldt5);
    }
}
