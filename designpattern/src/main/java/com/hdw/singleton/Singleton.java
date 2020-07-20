package com.hdw.singleton;

import org.junit.Test;

/**
 * @author hdw
 * @create 2020-06-28-15:06
 * @desc 描述
 *
 * 单例模式有八种方式
 * 1.饿汉式(静态常量)
 * 2.饿汉式(静态代码块)
 * 3.懒汉式(线程不安全)
 * 4.懒汉式(线程安全同步方法)
 * 5.懒汉式(线程安全同步代码块)
 * 6.双重检查
 * 7.静态内部类
 * 8.枚举
 */
public class Singleton {

    @Test
    public  void test(){
        Singleton7 instance = Singleton7.getInstance();
        Singleton7 instance2 = Singleton7.getInstance();

        System.out.println(instance==instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }

}

/**
 * 1.饿汉式(静态常量)
 * 1) 构造器私有化（防止NEW）
 * 2）类的内部创建对象
 * 3）向外暴露一个静态的公共方法 getInstant
 * 优缺点说明:
 *
 * 1)优点:这种写法比较简单,就是在类装载的时候就完成实例化。避免了线程同步问题。
 * 2)缺点:在类装载的时候就完成实例化,没有达到 Lazy Loading的效果。如果从始至终从未使用过这个实例,则会造成内存的浪费
 * 3)这种方式基于 classloader机制避免了多线程的同步问题,不过, Instance在类装载时就实例化,
 * 在单例模式中大多数都是调用 getinstance方法,
 * 但是导致类装载的原因有很多种,因此不能确定有其他的方式(或者其他的静态方法)导致类装载,
 * 这时候初始化 Instance就没有达到 lazy loading的效果
 * 4)结论:这种单例模式可用,可能造成内存浪费
 */
class Singleton1 {
    private Singleton1(){

    }

    private  final  static Singleton1 instance=new Singleton1();

    public static Singleton1 getInstance(){
        return instance;
    }

}

/**
 * 饿汉式(静态代码块)
 * 优缺点说明: 同上
 */
class Singleton2 {
    private Singleton2(){

    }

    private static  Singleton2 instance;

    static {
        instance =new Singleton2();
    }

    public static Singleton2 getInstance(){
        return instance;
    }

}


/**
 * 懒汉式(线程不安全)
 * 优缺点说明
 * 1)起到了 Lazy Loading的效果,但是只能在单线程下使用。
 * 2)如果在多线程下,一个线程进入了if( singleton=null判断语句块,还未来得及住下执行,
 * 另一个线程也通过了这个判断语句,这时便会产生多个实例。
 * 所以在多线程环境下不可使用这种方式
 * 3)结论:在实际开发中,不要使用这种方式
 */
class Singleton3 {

    private static Singleton3 instance;
    private Singleton3(){

    }

    //提供一个静态的公有方法，调用方法时候实例化
    public static Singleton3 getInstance(){
        if (instance==null) {
            instance=new Singleton3();
        }
        return instance;
    }

}

/**
 * 懒汉式(线程安全同步方法)
 *优缺点说明:
 *
 * 1)解决了线程不安全问题
 *
 * 2)效率太低了,每个线程在想获得类的实例时候,执行 getInstance()方法都要进行同步。
 * 而其实这个方法只执行一次实例化代码就够了,后面的想获得该类实例直接return就行了。方法进行同步效率太低
 *
 * 3)结论:在实际开发中,不推荐使用这种方式
 *
 */
class Singleton4 {
    private static Singleton4 instance;
    private Singleton4(){

    }

    public static synchronized Singleton4 getInstance(){
        if (instance==null) {
            instance=new Singleton4();
        }
        return instance;
    }
}

/**
 * 懒汉式(线程安全同步代码块)
 * 这是一种错误方式，不能保证线程安全
 *
 */
class Singleton5 {
    private static Singleton5 instance;
    private Singleton5(){

    }

    public static  Singleton5 getInstance(){
        if (instance==null) {
            synchronized(Singleton5.class) {
                instance=new Singleton5();
            }
        }
        return instance;
    }
}

/**
 *  双重检查
 *  实际中推荐使用，延迟加载效率高、线程安全
 */
class Singleton6 {
    private static volatile Singleton6 instance;
    private Singleton6(){

    }

    public static  Singleton6 getInstance(){
        if (instance==null) {
            synchronized(Singleton6.class) {
                if (instance == null){
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}


/**
 *  静态内部类
 *  懒加载、线程安全
 *  通过类实例保证线程安全
 *  推荐实际中使用
 */
class Singleton7 {

    private Singleton7(){

    }

    private static  class Singleton10 {
         private static  final Singleton7 INSTANCE=new Singleton7();
    }

    public static  Singleton7 getInstance(){
        return Singleton10.INSTANCE;
    }

}

/**
 *  枚举
 *
 *  可以实现单例
 *  推荐使用
 *
 */
enum Singleton8 {
    INSTANCE;

}

/**
 * Runtime
 * 采用饿汉式单例模式
 */
