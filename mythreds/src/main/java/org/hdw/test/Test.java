package org.hdw.test;

/**
 * @author hdw
 * @create 2020-07-14-21:07
 * @desc 描述
 */

public class Test {
    private static  long count = 0;
    private void add10K() {
        int idx = 0;
        while(idx++ < 10000) {
            count += 1;
        }
    }
    public static long calc()  {
        final Test test = new Test();
        // 创建两个线程，执行add()操作
        Thread th1 = new Thread(()->{
            test.add10K();
        });
        Thread th2 = new Thread(()->{
            test.add10K();
        });
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(Test.calc());
    }
}