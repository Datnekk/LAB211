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

public class Validate {
    Scanner sc = new Scanner(System.in);
    
    public String getName(ArrayList<Person> list){
        while (true) {            
            System.out.print("Please input name: ");
            String name = sc.nextLine();
            if(name.isEmpty()){
                System.err.println("name cannot be empty");
            }
            if (!name.isEmpty()){
                return name;
            }
        }
    }
    
    public String getAddress(ArrayList<Person> list){
        while (true) {            
            System.out.print("Please input address: ");
            String address = sc.nextLine();
            if(address.isEmpty()){
                System.err.println("address cannot be empty");
            }
            if (!address.isEmpty()){
                return address;
            }
        }
    }
    
    public double getSalary(ArrayList<Person> list){
       String input;
       double salary;
       do {
            System.out.print("Please input salary: ");
            input = sc.nextLine();
            if (input.trim().isEmpty()){
                System.err.println("salary cannot be empty");
            } else {
            }
            try {
                salary = Double.parseDouble(input);
                if (salary <= 0) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (NumberFormatException exception) {
                System.err.println("You must input digit");
                continue;
            } catch (Exception NegaError) {
                System.err.println("Salary is greater than zero");
                continue;
            } 
        } while (true);
        return salary;

    }
}
