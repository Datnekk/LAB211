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

    public Menu() {

    }

    public void Menus() {
        System.out.println("======= Doctor Management =======");
        System.out.println("1. Add Doctor");
        System.out.println("2. Update Doctor");
        System.out.println("3. Delete Doctor");
        System.out.println("4. Search Doctor");
        System.out.println("5. Exit");
    }

    public void displayMenu() {
        int choice = 0;
        Option o = new Option();
        do {
            new Menu().Menus();
            choice = Validation.getChoice("Enter Choice: ", 1, 5);         
            switch (choice) {
                case 1:
                    o.add();
                    break;
                case 2:
                    o.update();
                    break;
                case 3:
                    o.delete();
                    break;
                case 4:
                    o.search();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        } while (choice != 5);
    }

}
