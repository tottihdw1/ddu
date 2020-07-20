package com.hdw.proxy;

/**
 * @author hdw
 * @create 2020-07-06-20:12
 * @desc 描述
 * 被代理对象
 *
 */
public class TargetObject {

    public void say(){
        System.out.println("cglib 代理");
    }
}
