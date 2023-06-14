/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utils.Shop;
import Utils.Validation;

/**
 *
 * @author quang
 */
public class Menu {

    public void Menus() {
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
    }

    public void displayMenu() {
        int choice = 0;
        Shop s = new Shop();
        do {
            System.out.println("---------- Menu ----------");
            Menus();
            choice = Validation.getInt("Enter choice: ", 1, 4);
            switch (choice) {
                case 1:
                    s.create();
                    break;
                case 2:
                    s.view();
                    break;
                case 3:
                    s.shopping();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        } while (choice != 4);
    }
}
