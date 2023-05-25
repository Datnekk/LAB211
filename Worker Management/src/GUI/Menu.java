/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utuil.Option;
import Utuil.Validation;

/**
 *
 * @author quang
 */
public class Menu {
    static Menu m = new Menu();

        
    public void menu(){
        System.out.println("======= Worker Managemant =======");
        System.out.println("1. Add worker");
        System.out.println("2. Up Salary");
        System.out.println("3. Down Salary");
        System.out.println("4. Display Information Salary");
        System.out.println("5. Exit");
    }
    
    public static void displayMenu(){
        Option o = new Option();
        int choice = 0;
        do {            
            m.menu();
            choice = Validation.getChoice("Enter choice: ", 1, 5);
            switch(choice){
                case 1:
                    o.addWorker();
                    break;
                case 2:
                    o.updateSalary(1);
                    break;
                case 3:
                    o.updateSalary(2);
                    break;
                case 4:
                    o.diplayInformation();
                    break;
                case 5:
                    System.exit(0);
                    break;
            
            }
        } while (choice != 5);
    }
           
}
