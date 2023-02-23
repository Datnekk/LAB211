/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author quang
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ManagePerson {
    
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        Validate v = new Validate();
        Function f = new Function();
        String name ="";
        String address ="";
        double salary;
        System.out.println("====Management Person program====");
        for (int i=0; i<3; i++){
        System.out.println("\nInput Information of Person: ");    
        name = v.getName(list);
        address = v.getAddress(list);
        salary = v.getSalary(list);
        f.add(list, name, address, salary);
        }
        f.display(list);
    }
     
}
