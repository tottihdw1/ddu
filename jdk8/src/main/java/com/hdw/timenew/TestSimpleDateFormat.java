package com.hdw.timenew;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author hdw
 * @create 2020-06-23-10:37
 * @desc 描述
 */
public class TestSimpleDateFormat {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SimpleDateFormat smp=new SimpleDateFormat("yyyyMMdd");
        List<Future> list =new ArrayList <>();

        Callable<Date> task=new Callable <Date>() {
            @Override
            public Date call() throws Exception {
               // return smp.parse("20200623");

                return TestThreadLocal.convert("20200623");
            }
        };

        ExecutorService pool= Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {


            list.add(pool.submit(task));
        }

        for (Future<Date> future : list) {

            System.out.println(future.get());

        }

        pool.shutdown();
    }
}
