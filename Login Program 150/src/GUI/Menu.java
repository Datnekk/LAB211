/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Util.Option;
import Util.Validation;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author quang
 */
public class Menu {

    public Menu() {

    }

    public void Menus() {
        System.out.println("======= Login Program =======");
        System.out.println("1. Add User");
        System.out.println("2. Login");
        System.out.println("3. Exit");
    }

    public void displayMenu () throws NoSuchAlgorithmException {
        int choice = 0;
        Option o = new Option();
        do {
            new Menu().Menus();
            choice = Validation.getInt("Enter choice: ", 1, 3);
            switch (choice) {
                case 1:
                    o.add();
                    break;
                case 2:
                    o.login();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        } while (choice != 3);

    }
}
