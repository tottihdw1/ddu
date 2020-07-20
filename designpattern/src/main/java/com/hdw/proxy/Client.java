package com.hdw.proxy;

import org.junit.Test;

/**
 * @author hdw
 * @create 2020-07-06-20:27
 * @desc 描述
 */
public class Client {
    @Test
    public void test(){
        //创建目标对象
        TargetObject object = new TargetObject();
        //代理目标对象
        CglibProxyFactory proxyFactory = new CglibProxyFactory(object);
        //获取目标对象的实例
        TargetObject targetObject =(TargetObject) proxyFactory.getProxyInstance();
        //执行代理对象的方法，触发intercept方法，从而实现对目标对象的调用
        targetObject.say();
    }
}
