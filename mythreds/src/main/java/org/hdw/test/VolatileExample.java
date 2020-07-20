package org.hdw.test;

import org.junit.Test;

/**
 * @author hdw
 * @create 2020-07-15-10:53
 * @desc 描述
 */

// 以下代码来源于【参考1】
public class VolatileExample {
    int x = 0;
    volatile boolean v = false;
    public void writer() {
        x = 42;
        v = true;
    }
    public void reader() {
        if (v == true) {
            System.out.println(x);
        }
    }

    @Test
    public void test(){
        Thread t1=new Thread(()->{
            writer();
        }
        );
        Thread t2=new Thread(()->{
            reader();
        }
        );
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
