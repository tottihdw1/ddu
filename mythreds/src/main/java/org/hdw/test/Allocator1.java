package org.hdw.test;

import java.util.List;

/**
 * @author hdw
 * @create 2020-07-16-10:46
 * @desc 描述
 */

class Allocator1 {
    private List <Object> als;
    // 一次性申请所有资源
    synchronized void apply(
            Object from, Object to){
        // 经典写法
        while(als.contains(from) ||
                als.contains(to)){
            try{
                wait();
            }catch(Exception e){
            }
        }
        als.add(from);
        als.add(to);
    }
    // 归还资源
    synchronized void free(
            Object from, Object to){
        als.remove(from);
        als.remove(to);
        notifyAll();
    }
}
