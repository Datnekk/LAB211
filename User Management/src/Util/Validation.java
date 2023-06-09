/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.Scanner;

/**
 *
 * @author quang
 */
public class Validation {

    static Scanner sc = new Scanner(System.in);

    public static String getString(String msg, String err, int num) {
        String s = "";
        while (true) {
            System.out.print(msg);
            s = sc.nextLine();
            if (!s.isEmpty() && s.length() > num && !s.matches(".*//s.*")) {
                break;
            }
            System.err.println(err);
        }
        return s;
    }

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

}
