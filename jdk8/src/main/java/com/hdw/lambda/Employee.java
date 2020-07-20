package com.hdw.lambda;

import java.util.Objects;

/**
 * @author hdw
 * @create 2020-06-12-13:49
 * @desc 描述
 */
public class Employee {

    private String userName;
    private Integer age;
    private Integer salary;
    private  Status status;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Employee(Integer age) {
        this.age = age;
    }

    public Employee() {

    }

    public Employee(String userName, Integer age, Integer salary) {
        this.userName = userName;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String userName, Integer age, Integer salary, Status status) {
        this.userName = userName;
        this.age = age;
        this.salary = salary;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(userName, employee.userName) &&
                Objects.equals(age, employee.age) &&
                Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, age, salary);
    }

    public enum Status{
        FREE,
        BUSY,
        VOCATION
    }
}
