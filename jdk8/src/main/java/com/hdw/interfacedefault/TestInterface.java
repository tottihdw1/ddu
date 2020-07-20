package com.hdw.interfacedefault;

/**
 * @author hdw
 * @create 2020-06-22-16:20
 * @desc 描述
 */
public interface TestInterface {
    default String getName(){
       return "1989";
    }
}
