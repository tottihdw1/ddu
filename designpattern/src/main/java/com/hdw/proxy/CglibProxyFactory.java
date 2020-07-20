package com.hdw.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author hdw
 * @create 2020-07-06-20:10
 * @desc 描述
 */
public class CglibProxyFactory implements MethodInterceptor {

    //被代理目标对象
    private Object target;

    //传入被代理的对象
    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    //返回target的代理对象
    public  Object getProxyInstance(){
        //1.创建工具类
        //2.设置父类
        //3.设置回调函数
        //4.创建子类对象，即代理对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return  enhancer.create();
    }

    /**
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     *
     * 重写intercept方法，会调用目标对象的方法
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 代理模式 开始");
        Object invoke = method.invoke(target, objects);
        System.out.println("cglib 代理模式 提交");
        return invoke;
    }
}
