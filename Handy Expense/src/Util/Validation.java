/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import OBJ.Expenses;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author quang
 */
public class Validation {

    static Scanner sc = new Scanner(System.in);

    public static int getId(List<Expenses> elist) {
        if (elist.isEmpty()) {
            return 1;
        } else {
            int lastId = getLastId(elist);
            return lastId + 1;
        }
    }

    public static Expenses getExpenses(int id, List<Expenses> elist) {
        for (Expenses e : elist) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public static int getLastId(List<Expenses> elist) {
        int lastId = 0;
        for (Expenses e : elist) {
            int id = e.getId();
            if (id > lastId) {
                lastId = id;
            }
        }
        return lastId;
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

    public static String getDate(String msg) {
        String s;
        while (true) {
            try {
                SimpleDateFormat iF = new SimpleDateFormat("dd-MM-yyyy");
                SimpleDateFormat oF = new SimpleDateFormat("dd-MMM-yyyy");
                System.out.print(msg);
                s = sc.nextLine();
                Date date = iF.parse(s);
                s = oF.format(date);
                return s;
            } catch (ParseException e) {
                System.err.println("Invalid Date");
            }
        }
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
    
    public static int getTotal(List<Expenses> elist){
        int total = 0;
        for (Expenses e : elist) {
            total += e.getNumber();
        }
        return total;
    }
}
