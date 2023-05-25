/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utuil;

import OBJ.SalaryHistory;
import OBJ.Worker;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author quang
 */
public class Option {

    static Scanner sc = new Scanner(System.in);
    static List<Worker> wlist;
    static List<SalaryHistory> hlist;

    public Option() {
        wlist = new ArrayList<>();
        hlist = new ArrayList<>();
    }

    public void addWorker() {
        String id, name, worklocation;
        double salary;
        int age;
        
        id = Validation.getCode("Enter code: ", "Dublicated code, Pls enter again", wlist, 1);
        name = Validation.getString("Enter Name: ");
        age = Validation.getInt("Enter age: ", 18, 50);
        salary = Validation.getDouble("Enter Salary: ", 0.0001, Double.MAX_VALUE);
        worklocation = Validation.getString("Enter Work place: ");
        
        wlist.add(new Worker(id, name, age, salary, worklocation));
    }
    
    public void updateSalary(int mode){
        double update = 0;
        String status = "";
        
        String id = Validation.getCode("Enter code: ", "Id must existed in database and not null", wlist, 2);
        
        double money = Validation.getDouble("Enter salary: ", 0.00001, Double.MAX_VALUE);
        
        Worker w = Validation.getWorker(id, wlist);
        
        if (mode == 1 ) {
            update = w.getSalary() + money;
            status = "UP";
        } else if(mode == 2 && w.getSalary() > update) {
            update = w.getSalary() - money;
            status = "DOWN";
        }
        w.setSalary(update);
        hlist.add(new SalaryHistory(id, w.getName(), w.getAge(), w.getSalary(), status, java.time.LocalDate.now()));
    }
    
    public void diplayInformation(){
        display(hlist);
    }
    
    private static void display(List list){
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
