package com.hdw.optional;

import com.hdw.lambda.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * @author hdw
 * @create 2020-06-22-13:19
 * @desc 描述
 */
public class TestOptional {

    /**
     * Optional 容器类的常见方法：
     * Optional.of(T t)创建一个optional实例
     * Optional.empty() 创建一个空的optional实例
     * Optional.ofNullable(T t) 若T 不为null。创建optional实例，否则创建空实例。
     * isPresent() 判断是否包含值
     * orElse(T t)  如果调用对象包含值，返回该值，否则返回T
     * orElseGet(Supplier s) 如果调用对象包含值，返回该值，否者返回s获取值
     * map(Funtion f) 如果有值对其处理，返回处理后的Optional，或者返回Optional.empty()
     * flatMap(Function mapper) 与map类似，要求返回值必须是Optional
     *
     */
    @Test
    public void  test(){
        //参数是null也是空指针
        Optional <Employee> employee = Optional.of(new Employee());
        System.out.println(employee.get());
        //空的Optional，取不到值
        Optional <Employee> empty = Optional.empty();
        // System.out.println(empty.get());
        //参数是null也是空指针
        Optional <Employee> op = Optional.ofNullable(new Employee());
        if(op.isPresent()){
            System.out.println(op.get());
        }
        //无值给默认值
        op.orElse(new Employee("hdw",11,555));

       //供给型接口 返回生成的对象
        Employee employee1 = op.orElseGet( () -> new Employee("hdw1",11,555));
    }

    @Test
    public void  test1(){
        Optional <Employee> op = Optional.ofNullable(new Employee("hdw",11,555));
        //函数处理返回值
        Optional <Employee> emp = op.map(e -> {
            e.setUserName("haha") ;
        return e;
        });
        System.out.println(emp);

        //返回值类型必须 Optional类型
        Optional <String> s = op.flatMap(e -> Optional.of(e.getUserName()));
        System.out.println(s.get());

    }

}
