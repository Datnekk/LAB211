/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author quang
 */
public class Login {

    Scanner sc = new Scanner(System.in);
    Map<String, String> db;

    public Login() throws IOException {
        db = new HashMap<>();
        loadData();
    }

    private void loadData() throws IOException {
        String filePath = "C:\\Users\\quang\\OneDrive\\Documents\\NetBeansProjects\\Worker Management\\user.txt";
        File f = new File(filePath);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                break;
            } else {
                String[] login = line.split("[ ]");
                String username = login[0].trim();
                String password = login[1].trim();
                db.put(username, password);
            }
        }

        br.close();
        fr.close();
    }

    private void saveData() throws IOException {
        String filePath = "C:\\Users\\quang\\OneDrive\\Documents\\NetBeansProjects\\Worker Management\\user.txt";
        File f = new File(filePath);
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        
        for (Map.Entry<String, String> entry : db.entrySet()) {
            bw.write(entry.getKey() + " " + entry.getValue() + "\n");
            
        }
        
        bw.close();
        fw.close();
    }

    public void create() throws IOException {
        String username = Validation.getString("Enter Username: ", "Username must be at least 5 characters and no spaces ", 5);
        
        if (db.containsKey(username)) {
            System.err.println("Username is not allowed to coincide with the existing username in the database");
        }
        String password = Validation.getString("Enter Password: ", "Password must be at least 6 characters and no spaces.", 6);
        db.put(username, password);
        System.out.println("Create Account succesfully !!!");
        saveData();
    }

    public void login() throws IOException {
        System.out.print("Enter Username: ");
        String u = sc.nextLine();
        System.out.print("Enter Password: ");
        String p = sc.nextLine();
        if (db.containsKey(u) && db.containsValue(p)) {
            System.out.println("Login successful !!");
        } else {
            System.err.println("Not Found !!!");
        }
        saveData();
    }

}
