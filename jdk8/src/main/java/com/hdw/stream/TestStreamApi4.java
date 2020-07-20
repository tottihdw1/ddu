package com.hdw.stream;

import com.hdw.lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hdw
 * @create 2020-06-17-15:45
 * @desc 描述
 */
public class TestStreamApi4 {

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
     * 练习1
     * 给定一个数字列表，返回一个由每个数字平方构成的列表
     * 例如  [1,2,3,4,5,6,7] -> [1,4,9,16,25,36,49]
     */
    @Test
    public  void test(){
        List <Integer> list= Arrays.asList(1,2,3,4,5,6,7);
        List <Integer> collect = list.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println(collect);


    }


    /**
     * 练习2
     * 算员工集合中不重复名称的数量
     */
    @Test
    public  void test1(){

        long count = emp.stream().map(Employee::getUserName).distinct().count();
        System.out.println(count);

    }
}
