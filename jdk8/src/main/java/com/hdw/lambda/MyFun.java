package com.hdw.lambda;

/**
 * @author hdw
 * @create 2020-06-12-13:36
 * @desc 描述
 */
@FunctionalInterface
public interface MyFun<T> {

    public T getValue(Integer num);

}
