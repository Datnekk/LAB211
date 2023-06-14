/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author quang
 */
public class Validation {

    static Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) {
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
                System.out.println("Must be in the rage of " + min + " --> " + max);
            }
        }
        return i;
    }
    
    public static double getDouble(String msg, double min, double max) {
        double i;
        while (true) {
            try {
                System.out.print(msg);
                i = Double.parseDouble(sc.nextLine());
                if (i >= min && i <= max) {
                    break;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                System.err.println("Must be in the rage of " + min + " -->" + max);
            }
        }
        return i;
    }
    
     public static String getString(String msg) {
        String s;
        while (true) {
            try {
                System.out.print(msg);
                s = sc.nextLine();
                if (!s.isEmpty()) {
                    break;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                System.err.print("Please enter string");
            }
        }
        return s;
    }
     
      public static boolean getYN(String msg) {
        boolean check = false;
        while (!check) {
            System.out.print(msg);
            String s = sc.nextLine();
            try {
                if (s.equalsIgnoreCase("Y")) {
                    check = true;
                } else if (s.equalsIgnoreCase("N")) {
                    check = true;
                    return false;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException ex) {
                System.out.println("Only enter Y/N");
            }
        }
        return true;
    } 
}
