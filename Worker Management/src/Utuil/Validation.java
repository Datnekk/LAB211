/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utuil;

import OBJ.Worker;
import java.util.List;
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
                System.out.println("Must be in the rage of "+min+" -->"+max);
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
                 System.out.println("Must be in the rage of "+min+" -->"+max);
            }
        }
        return i;
    }

    public static String getCode(String msg, String err, List<Worker> wlist, int mode) {
        String s;
        while (true) {
            System.out.print(msg);
            s = sc.nextLine();
            if (!s.isEmpty()) {
                if ((mode == 1 && getWorker(s, wlist) == null)
                        || (mode == 2) && getWorker(s, wlist) != null) {
                    break;
                }
            }
            System.err.println(err);
        }
        return s;
    }

    public static Worker getWorker(String id, List<Worker> wlist) {
        for (Worker w : wlist) {
            if (w.getId().equalsIgnoreCase(id)) {
                return w;
            }
        }
        return null;
    }
    
    public static String getString(String msg){
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
                System.out.print("Please enter string");
            }
        }
        return s;
    }
    
    public static int getChoice(String msg,int min, int max){
    int c;
        while (true) {            
            try {
                System.out.print(msg);
                c = Integer.parseInt(sc.nextLine());
                if (c>=min && c<=max) {
                    break;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                System.out.println("Pls enter choice from: "+min+" -->"+max);
            }
        }
        return c;
    }
}
