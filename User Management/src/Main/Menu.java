/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Util.Login;
import Util.Validation;
import java.io.IOException;

/**
 *
 * @author quang
 */
public class Menu {

    public void Menus() {
        System.out.println("====== USER MANAGEMENT SYSTEM ======");
        System.out.println("1. Create a new account");
        System.out.println("2. Login system");
        System.out.println("3. Exit");
    }

    public void displayMenu() throws IOException {
        Login l = new Login();
        int choice = 0;
        do {
            Menus();
            choice = Validation.getInt("> Choose: ", 1, 3);
            switch (choice) {
                case 1:
                    l.create();
                    break;
                case 2:
                    l.login();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        } while (choice != 3);
    }
}
