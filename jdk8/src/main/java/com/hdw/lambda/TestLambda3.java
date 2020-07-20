package com.hdw.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Predicate;

/**
 * @author hdw
 * @create 2020-06-12-13:51
 * @desc 描述
 */
public class TestLambda3 {

    @Test
    public   void test(){
        ArrayList<Employee> list=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Employee e=new Employee();
            e.setUserName("小"+i);
            e.setAge((int) (Math.random()*100));
            e.setSalary((int) (Math.random()*500));
            list.add(e);
        }

        Comparator<Employee> C=(x,y)-> {
            Integer age = x.getAge();
            String userName = x.getUserName();
            Integer age1 = y.getAge();
            String userName1 = y.getUserName();
            if(age==age1){
                return userName.compareTo(userName1);

            }else{
                return Integer.compare(age,age1);
            }

        };

        Collections.sort(list, C);
        for(Employee emp:list){

            System.out.println(emp);
        }
    }
}
