/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import OBJ.User;
import java.security.NoSuchAlgorithmException;
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

    public void add() throws NoSuchAlgorithmException {
        String Username = Validation.getLogin("Enter Username: ", "Username already existed in DB", ulist, 1);

        String Password = Validation.getLogin("Enter Password: ", "Password cannot null,empty", ulist, 1);

        String Name = Validation.getString("Enter Name: ", "Invalid Name", 0);

        String Phone = Validation.getPhone("Enter Phone: ", "Phone must be 10 or 11 number");

        String Email = Validation.getEmail("Enter Email Address: ");

        String DOB = Validation.getDOB("Enter DOB: ");

        String md5pass = Validation.md5Hash(Password);

        ulist.add(new User(Username, md5pass, Name, Phone, Email, DOB));

        display();
    }

    public void login() throws NoSuchAlgorithmException {

        System.out.print("Enter username: ");
        String Username = sc.nextLine();

        System.out.print("Enter password: ");
        String Password = sc.nextLine();

        User u = Validation.getUser(Username, ulist);

        if (!ulist.isEmpty() && Validation.validateMD5(Password, u.getPassword())) {
            System.out.println("Login succesfully !!");

            System.out.println("------- Wellcome -------");

            System.out.println("Hi " + u.getName() + ", do you want to change password now? Y/N");

            boolean checkYN = Validation.getYN("Enter your choice: ");
            if (checkYN) {
                String oPass = Validation.getLogin("Old password: ", "Wrong Password !!", ulist, 2);

                String nPass = Validation.getLogin("Enter new password: ", "New password cannot match with old Password", ulist, 1);

                String rnPass = Validation.getLogin("Renew Password: ", "Not match !!!", ulist, 1);

                if (nPass.equals(rnPass)) {
                    String md5pass = Validation.md5Hash(rnPass);

                    u.setPassword(md5pass);

                    System.out.println("Change password succesfully !!");

                    display();
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

    public void display() {
        for (User u : ulist) {
            System.out.println(u);
        }
    }
}
