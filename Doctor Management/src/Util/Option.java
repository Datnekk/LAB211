/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import OBJ.Doctor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author quang
 */
public class Option {

    Scanner sc = new Scanner(System.in);
    static List<Doctor> dlist;

    public Option() {
        dlist = new ArrayList<>();
    }

    public void add() {
        String Code = Validation.getCode("Enter code: ", "Doctor code must be unique and not null", dlist, 1);
        String Name = Validation.getString("Enter name: ");
        String Specialization = Validation.getString("Enter Specialization: ");
        int Availability = Validation.getInt("Enter Availability: ", 0, Integer.MAX_VALUE);

        dlist.add(new Doctor(Code, Name, Specialization, Availability));
        displayDoctor();
    }

    public void update() {
        System.out.println("------- Update Doctor -------");

        String Code = Validation.getCode("Enter code: ", "Doctor code does not exist", dlist, 2);

        Doctor d = Validation.getDoctor(Code, dlist);

        String Name = Validation.getString("Enter name: ");

        String Specialization = Validation.getString("Enter Specialization: ");

        int Availability = Validation.getInt("Enter Availability: ", 0, Integer.MAX_VALUE);

        d.setName(Name);
        d.setSpecialization(Specialization);
        d.setAvailability(Availability);
        displayDoctor();
    }

    public void delete() {
        String code = Validation.getCode("Enter code: ", "Doctor code does not exist", dlist, 2);

        Iterator<Doctor> iterator = dlist.iterator();
        while (iterator.hasNext()) {
            Doctor doctor = iterator.next();
            if (doctor.getCode().equals(code)) {
                iterator.remove();
            }
        }
        displayDoctor();
    }

    public void search() {
        String s = Validation.getString("Enter text: ");
        boolean found = false;

        for (Doctor d : dlist) {
            if (d.getCode().equals(s) || d.getName().equalsIgnoreCase(s) || d.getSpecialization().equalsIgnoreCase(s)) {
                System.out.println(d);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not found!!");
        }
    }

    public void displayDoctor() {
        if (dlist.size() > 0) {
            displayDoc();
        } else {
            System.out.println("Nothing to show !! ");
        }
    }
    
    public static void displayDoc(){
        System.out.printf("%-5s %-8s %-15s %5s\n","Code","Name","Specialization","Availability");
        for (Doctor d : dlist) {
            System.out.println(d);
        }
    }
    
    public void diplay(List list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
