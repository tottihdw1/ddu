package com.hdw.lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author hdw
 * @create 2020-06-14-21:28
 * @desc 描述
 *
 *
 * 一方法引用： 若Lambda体中的内容有方法已经实现，我们可以使用“方法引用”
 * 可以理解方法引用是Lambda表达式的另外一种形式
 *
 * 需要函数接口的参数与返回值类型 与调用方法的参数与返回值类型一致
 *
 * 主要三种语法格式：
 * 对象：：实例方法名
 * 类名：静态方法名
 * 类名：实例方法名
 *
 *
 * 二构造器引用
 * 格式：
 * ClassName:new
 *
 * 三数组引用
 * 格式：
 * type[]::new;
 *
 *
 *
 */
public class TestMethodRef {

    //对象：：实例方法名
    @Test
    public  void test1(){

        //lambda 体
        Consumer<String> con= (x)->System.out.println(x);
        con.accept("666");

        //方法引用代替lambda体
        PrintStream pr=System.out;
        Consumer<String> con1= pr::println;
        con1.accept("123456");

        Consumer<String> con2= System.out::println;

        Employee emp=new Employee();

        //lambda 体
        Supplier<Integer> sp=()-> emp.getAge();
        Integer num = sp.get();
        System.out.println(num);

        Supplier<Integer> sp1=emp::getAge;
        Integer num1 = sp1.get();
        System.out.println(num1);


    }


    //类名：静态方法名
    @Test
    public  void test2(){
        //lambda 体
        Comparator<Integer> com=(x,y)->Integer.compare(x,y);
       //方法引用
        Comparator<Integer> com1=Integer::compareTo;
        int test = com1.compare(1, 2);
        System.out.println(test);


    }

    //类名：实例方法名
    @Test
    public  void test3(){
        //lambda 体
        BiPredicate<String,String> pre=(x,y)->x.equals(y);

        //方法引用 如果 lambda 参数列表的第一个参数是实例方法的调用者，而第二参数是实例方法参数时，可以使用 类名：：方法名
        BiPredicate<String,String> pre1=String::equals;
    }

    //构造器引用 ClassName:new
    @Test
    public  void test4(){
        // lambda表达式
        Supplier<Employee> sup=()->new Employee();
        //构造器引用
        Supplier<Employee> sup1=Employee::new;
        Employee employee = sup1.get();
        System.out.println(employee.getClass().getName());

    }

    //构造器引用 ClassName:new
    //调用的构造器的参数列表与函数接口中的抽象方法的参数列表一致
    @Test
    public  void test5(){
        // lambda表达式
        Function<Integer,Employee> fun=(x)->new Employee(x);
        //构造器引用
        Function<Integer,Employee> fun1=Employee::new;
        Employee emp = fun1.apply(100);
        System.out.println(emp.getAge());


    }


    /**
     *  数组引用
     *  格式：
     *        type::new
     */
    @Test
    public  void test6(){
        // lambda表达式
        Function<Integer,String[]> fun=(x)->new String[x];
        //数组引用
        Function<Integer,String[]> fun1=String[]::new;
        String[] temp = fun1.apply(5);
        System.out.println(temp.length);

    }
}
