package com.hdw.stream;

import com.hdw.lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author hdw
 * @create 2020-06-15-14:51
 * @desc 描述
 *
 * 中间操作
 *
 */
public class TestStreamApi2 {

    List<Employee> emp= Arrays.asList(
            new Employee("张三",20,3000),
            new Employee("李四",30,4000),
            new Employee("王五",40,5000),
            new Employee("赵六",50,6000),
            new Employee("田七",50,6000),
            new Employee("田七",50,6000),
            new Employee("田七",50,6000)
    );



    /**
     * 筛选与切片
     * filter-接收Lambda,从流中排除某些元素。
     * limit-截断流，使其元素不超过给定数量。
     * skip(n)-跳过元素，返回一个丢掉前N个元素的流。若流中的元素不足N个则返回一个空流。与limit(n)互补
     * distinct-筛选，通过流所生成的元素的hashCode()和equals()去掉重复元素
     */
    @Test
    public  void test(){
        //filter 注意：中间操作不执行任何操作，只有执行终止操作，才会一次性执行全部，此行为称为“惰性求值”
        //内部迭代：迭代操作由Stream API 完成
       // emp.stream().filter((x)->x.getAge()>20).forEach(System.out::println);

        //limit  注意：短路操作，找到结果就返回，提高效率
       // emp.stream().limit(2).forEach(System.out::println);

        //skip
       // emp.stream().skip(2).forEach(System.out::println);

        //distinct
        emp.stream().filter((x)->x.getSalary()>4000).distinct().forEach(System.out::println);
    }

    /**
     * 映射
     * map-接收lambda,将元素转化成其它形式或提取信息，接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
     * flatMap-接收一个函数作为参数，将流中的每个值都换成另外一个流。然后把所有流连接为一个流
     */
    @Test
    public  void test1(){
        List<String> list=Arrays.asList("aaa","bbb","ccc","ddd","eee","fff","ggg");
        //map
/*
        list.stream().map((x)->{
            return x.toUpperCase();
        }).forEach(System.out::println);
        System.out.println("-------------------------------");
        emp.stream().map((emp)->emp.getUserName()).distinct().forEach(System.out::println);*/

        System.out.println("-------------------------------");

        //flatMap
        Stream <Stream <Character>> s1 = list.stream().map(TestStreamApi2::filterStream);
        s1.forEach(s2->s2.forEach(System.out::println));

        System.out.println("-------------------------------");
        list.stream().flatMap(TestStreamApi2::filterStream).forEach(System.out::println);

    }

    /**
     *
     * @param str
     * @return
     */
    public static Stream<Character> filterStream(String str){
        ArrayList<Character> list=new ArrayList <>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }

        return list.stream();
        
    }

    /**
     * 排序
     * sorted()-自然排序(Comparable)
     * sorted(Comparator com)-定制【排序】
     */
    @Test
    public  void test2(){
        //sorted()-自然排序(Comparable)
        List<String> list=Arrays.asList("bbb","ccc","ddd","eee","fff","ggg","aaa");
        list.stream().sorted().forEach(System.out::println);
        System.out.println("-----------------------------");
        //sorted(Comparator com)-定制【排序】
        emp.stream().sorted((x,y)->Integer.compare(y.getAge(),x.getAge())).forEach(System.out::println);
    }
}
