/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import OBJ.Doctor;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author quang
 */
public class Validation {
    static Scanner sc = new Scanner(System.in);
    
    
    public static String getString(String msg){
        String s;
        while (true) {            
            try {
                System.out.print(msg);
                s = sc.nextLine().trim();
                if (!s.isEmpty()) {
                    break;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                System.out.print("Please enter string");
            }
        }
        return s;
    }
    
    public static int getInt(String msg, int min, int max) {
        int i;
        while (true) {
            try {
                System.out.print(msg);
                i = Integer.parseInt(sc.nextLine());
                if (i > min && i <= max) {
                    break;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                System.out.println("Must be in the rage of "+min+" -->"+max);
            }
        }
        return i;
    }
    
    public static String getCode(String msg, String err, List<Doctor> dlist, int mode) {
        String s;
        while (true) {
            System.out.print(msg);
            s = sc.nextLine();
            if (!s.isEmpty()) {
                if ((mode == 1 && getDoctor(s, dlist) == null)
                        || (mode == 2) && getDoctor(s, dlist) != null) {
                    break;
                }
            }
            System.err.println(err);
        }
        return s;
    }
    
    public static Doctor getDoctor(String code,List<Doctor> dlist){
        for (Doctor d : dlist) {
            if (d.getCode().contains(code)) {
                return d;
            }
        }
        return null;
    }
    
    public static int getChoice(String msg, int min, int max) {
        int i;
        while (true) {
            try {
                System.out.print(msg);
                i = Integer.parseInt(sc.nextLine());
                if (i >= min && i <= max) {
                    break;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                System.out.println("Must be in the rage of "+min+" -->"+max);
            }
        }
        return i;
    }
}
