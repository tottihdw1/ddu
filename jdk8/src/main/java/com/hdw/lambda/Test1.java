package com.hdw.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author hdw
 * @create 2020-06-11-13:44
 * @desc 描述
 */
public class Test1 {

    //匿名内部类
    @Test
    public void test1(){
        Comparator<Integer> com=new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> tr=new TreeSet<>(com);
    }

    //lambda
    @Test
    public void test2(){
        Comparator<Integer> com=(x,y) ->  Integer.compare(x,y);
    }
}
