/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import OBJ.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author quang
 */
public class Option {

    static Scanner sc = new Scanner(System.in);
    List<User> ulist;

    public Option() {
        ulist = new ArrayList<>();
    }

    public void add() {
        String Username = Validation.getLogin("Enter Username: ", "Username already existed in DB", ulist, 1);
        String Password = Validation.getLogin("Enter Password: ", "Password cannot null,empty", ulist, 1);
        String Name = Validation.getString("Enter Name: ", "Invalid Name", 0);
        String Phone = Validation.getString("Enter Phone: ", "Phone must be 10 or 11 number", 9);
        String Email = Validation.getEmail("Enter Email Address: ");
        String DOB = Validation.getDOB("Enter DOB: ");

        ulist.add(new User(Username, Password, Name, Phone, Email, DOB));
    }

    public void login() {
        boolean check = false;
        boolean cf = false;
        System.out.print("Enter username: ");
        String Username = sc.nextLine();
        System.out.print("Enter password: ");
        String Password = sc.nextLine();

        for (User u : ulist) {
            if (u.getUsername().equals(Username) && u.getPassword().equals(Password)) {
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("Login succesfully !!");
            System.out.println("------- Wellcome -------");
            User user = Validation.getUser(Username, ulist);
            System.out.println("Hi " + user.getName() + ", do you want to change password now? Y/N");
            boolean checkYN = Validation.getYN("Enter your choice: ");
            if (checkYN) {
                String oPass = Validation.getLogin("Old password: ", "Wrong Password !!", ulist, 2);
                String nPass = Validation.getLogin("Enter new password: ", "New password cannot match with old Password", ulist, 1);
                String rnPass = Validation.getLogin("Renew Password: ", "Not match !!!", ulist, 1);
                if (nPass.equals(rnPass)) {
                    user.setPassword(rnPass);
                    System.out.println("Change password succesfully !!");
                } else {
                    System.err.println("Not match !!, Change password failed");

                }
            } else {
                System.out.println("Dont change password");
            }
        } else {
            System.err.println("Wrong Username or Password");
        }
    }
}
