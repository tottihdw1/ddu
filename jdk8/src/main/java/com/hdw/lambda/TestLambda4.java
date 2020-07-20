package com.hdw.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author hdw
 * @create 2020-06-12-14:36
 * @desc 描述
 *
 * java8 内置4大核心函数式接口
 *
 * 1. Consumer<T> 消费型接口
 *     void accept(T t);
 *
 * 2. Supplier<T> 生产型接口
 *    T get();
 *
 * 3 Function<R,T> 函数型接口
 *   R apply(T t);
 *
 * 4 Predicatre<T> 断言型接口
 *   boolean test(T t);
 */
public class TestLambda4 {

    //Consumer<T> 消费型接口
    @Test
    public  void  test(){
     work(100,(x)-> System.out.println("消费："+ x));
    }

    public void work(double num, Consumer<Double> con){
        con.accept(num);
    }

    //Supplier<T> 生产型接口
    @Test
    public  void  test1(){
        List <Integer> products = product(100, () -> (int) (Math.random() * 100));
        for (Integer product : products) {
            System.out.println(product);
        }
    }

    public List <Integer> product(int num, Supplier<Integer> s){
        ArrayList<Integer> list=new ArrayList <>();
        for (int i = 0; i <num ; i++) {
            list.add(s.get());
        }
                return list;
    }

    //Function<R,T> 函数型接口
    @Test
    public  void  test2(){
        String ll = dealStr("天涯", (x) -> x+"明月");
        System.out.println(ll);
        String ss = dealStr("我想我是海", (x) -> x.substring(1, 2));
        System.out.println(ss);
    }

    public String dealStr(String content, Function<String,String> func){

        return func.apply(content);

    }


    //Predicatre<T> 断言型接口
    @Test
    public void test3(){

        boolean check = check(0, (x) -> x > 0);
        System.out.println(check);

    }

    public boolean check(int i,Predicate<Integer> pred){

       return  pred.test(i);
    }
}
