package com.hdw.stream;

import com.hdw.lambda.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hdw
 * @create 2020-06-17-11:34
 * @desc 描述
 *
 * 终止操作
 */
public class TestStreamApi3 {

    List <Employee> emp= Arrays.asList(
            new Employee("黄一",20,3000, Employee.Status.FREE),
            new Employee("张三",20,3000, Employee.Status.BUSY),
            new Employee("李四",30,4000, Employee.Status.VOCATION),
            new Employee("王五",40,5000, Employee.Status.VOCATION),
            new Employee("赵六",50,6000, Employee.Status.BUSY),
            new Employee("田七",70,7000, Employee.Status.FREE),
            new Employee("田七",75,8000, Employee.Status.FREE)

    );


    /**
     * 查找与匹配
     * allMatch-检查是否匹配所有元素
     * anyMatch-检查是否至少匹配一个元素
     * noneMtch-检查是否没有匹配所有元素
     * findFirst-返回第一个元素
     * findAny-返回当前流中的任意元素
     * count-返回流中元素的总个数
     * max-返回流中最大值
     * min-返回流中最小值
     */
    @Test
    public void test1(){
        //allMatch-检查是否匹配所有元素
        boolean b = emp.stream().allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);

        System.out.println("--------------------------------");
        //anyMatch-检查是否至少匹配一个元素
        System.out.println(emp.stream().anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY)));
        System.out.println("--------------------------------");
        //noneMtch-检查是否没有匹配所有元素
        boolean b1 = emp.stream().noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);
        System.out.println("--------------------------------");
        //findFirst-返回第一个元素
        Optional <Employee> first = emp.stream().findFirst();
        System.out.println(first.get().getUserName());
        System.out.println("--------------------------------");
        //findAny-返回当前流中的任意元素
        Optional <Employee> any = emp.stream().filter(e -> e.getStatus().equals(Employee.Status.VOCATION)).findAny();
        System.out.println(any.get().getUserName());
        System.out.println("--------------------------------");
        //count-返回流中元素的总个数
        System.out.println(emp.stream().count());
        System.out.println("--------------------------------");
        //max-返回流中最大值
        Optional <Employee> max = emp.stream().max((x, y) -> Integer.compare(x.getAge(), y.getAge()));
        System.out.println(max.get().getUserName());
        System.out.println("--------------------------------");
        //min-返回流中最小值
        Optional <Integer> min = emp.stream().map(Employee::getSalary).min(Double::compare);
        System.out.println(min.get());


    }

    /**
     * 归约
     * reduce(T identity, BinaryOperator)/reduce(BinaryOperator)-可以将流中的元素反复结合起来，得到一个新值
     * map加reduce的连接通常称为map-reduce模式，因为google进行网络搜索而闻名，大数据处理思路
     */
    @Test
    public void test2(){
        List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9);
        Integer reduce = list.stream().reduce(0, (x, y) -> x);
        System.out.println(reduce);
        System.out.println("--------------------------------");
        Optional <Integer> reduce1 = emp.stream().map(Employee::getSalary).reduce(Integer::sum);
        System.out.println(reduce1.get());
    }

    /**
     * 收集
     * collect-将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
     * Collectors工具类，提供很多静态方法，可以方便的创建常见的收集器实例
     */
    @Test
    public void test3(){
        String collect = emp.stream().map(Employee::getUserName).collect(Collectors.joining());
        System.out.println(collect);
        System.out.println("--------------------------");
        Set <String> collect1 = emp.stream().map(Employee::getUserName).collect(Collectors.toSet());
        collect1.forEach(System.out::println);
        System.out.println("--------------------------");
        HashSet <String> collect2 = emp.stream().map(Employee::getUserName).collect(Collectors.toCollection(HashSet::new));
        collect2.forEach(System.out::println);
    }

    @Test
    public void test4(){
        //算总数
        Long collect = emp.stream().collect(Collectors.counting());
        System.out.println(collect);
        //算平均值
        Double collect1 = emp.stream().collect(Collectors.averagingInt(Employee::getAge));
        System.out.println(collect1);
        //总和
        DoubleSummaryStatistics collect2 = emp.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect2.getSum());
        //最大值
        Optional <Employee> collect3 = emp.stream().collect(Collectors.maxBy((x, y) -> Double.compare(x.getSalary(), y.getSalary())));
        System.out.println(collect3.get());

    }

    //分组
    @Test
    public void test5(){
        Map <Employee.Status, List <Employee>> collect = emp.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(collect);

    }

    //多级分组
    @Test
    public void test6(){
        Map <Employee.Status, Map <String, List <Employee>>> collect = emp.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(Employee::getUserName)));
        System.out.println(collect);

    }

    //分片（分区）
    @Test
    public void test7(){
        Map <Boolean, List <Employee>> collect = emp.stream().collect(Collectors.partitioningBy((e) -> e.getAge() > 60));
        System.out.println(collect);
    }

}
