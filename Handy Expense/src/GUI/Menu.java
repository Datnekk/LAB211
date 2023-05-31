/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Util.Option;
import Util.Validation;

/**
 *
 * @author quang
 */
public class Menu {
    
    public Menu(){
    
    }

    public void Menus() {
        System.out.println("======= Handy Expenses Program =======");
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expenses");
        System.out.println("3. Delete an expense");
        System.out.println("4. Quit");
    }

    public static void diplayMenu() {
        int choice;
        Option o = new Option();
        do {
            new Menu().Menus();
            choice = Validation.getInt("Enter your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    o.add();
                    break;
                case 2:
                    o.diplayElist();
                    break;
                case 3:
                    o.delete();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }

        } while (choice != 4);
    }

}
