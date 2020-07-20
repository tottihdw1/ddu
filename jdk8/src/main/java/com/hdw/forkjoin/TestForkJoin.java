package com.hdw.forkjoin;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

/**
 * @author hdw
 * @create 2020-06-19-10:42
 * @desc 描述
 */
public class TestForkJoin {

    /**
     * forkjoin
     */
    @Test
    public void test(){
        Instant start=Instant.now();
        ForkJoinPool pool=new ForkJoinPool();
        ForkJoinCalculater fjk=new ForkJoinCalculater(1,10000000000l);
        Long sum = pool.invoke(fjk);
        Instant end=Instant.now();
        System.out.println(sum);
        System.out.println("fjk time: "+ Duration.between(start,end).toMillis());

    }

    /**
     * for
     */
    @Test
    public void test1(){
        Instant start=Instant.now();
        long sum=0l;
        for (long i = 1; i <=10000000000l ; i++) {
            sum=sum+i;
        }
        Instant end=Instant.now();
        System.out.println(sum);
        System.out.println("for time: "+ Duration.between(start,end).toMillis());

    }

    /**
     * java8 并行流
     */
    @Test
    public void test2(){
        Instant start=Instant.now();
        long reduce = LongStream.rangeClosed(1, 10000000000l).parallel().reduce(0, Long::sum);
        Instant end=Instant.now();
        System.out.println(reduce);
        System.out.println("for time: "+ Duration.between(start,end).toMillis());
    }

}
