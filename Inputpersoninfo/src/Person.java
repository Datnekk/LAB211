/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author quang
 */
public class Person {
    protected String name;
    protected String address;
    protected double salary;

    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return("Name: "+name+"\n"+"Address: "+address+"\n"+"Salary: "+salary);
    }

    int compareTo(Person person) {
    int res =0;
    if (this.salary < person.getSalary()){
        res =-1;
    }
    if (this.salary > person.getSalary()){
        res =1;
    }
    return res;
    }
    

}
