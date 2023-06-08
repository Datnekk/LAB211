/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import OBJ.User;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            if (!s.isEmpty() && s.length() > num) {
                break;
            }
            System.err.println(err);
        }
        return s;
    }

    public static String getDOB(String msg) {
        SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        df.setLenient(false);
        Date date;
        while (true) {
            try {
                System.out.print(msg);
                date = df.parse(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid date,pls input again: ");
            }
        }
        return df.format(date);
    }

    public static String getEmail(String msg) {
        String s;
        while (true) {
            try {
                boolean check;
                System.out.print(msg);
                s = sc.nextLine();
                check = isEmail(s);
                if (check) {
                    System.out.println("Valid Email");
                    break;
                }
                throw new Exception();
            } catch (Exception ex) {
                System.out.println("Invalid Email pls enter again");
            }
        }
        return s;
    }

    public static boolean isEmail(String s) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static String getPhone(String msg, String err) {
        String s;
        while (true) {
            try {
                boolean check;
                System.out.print(msg);
                s = sc.nextLine();
                check = isPhone(s);
                if (check) {
                    break;
                }
                throw new Exception();
            } catch (Exception ex) {
                System.err.println("Invalid Phone pls enter again");
            }
        }
        return s;
    }

    public static boolean isPhone(String s) {
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static String getLogin(String msg, String err, List<User> ulist, int mode) {
        String s;
        while (true) {
            System.out.print(msg);
            s = sc.nextLine();
            if (!s.isEmpty()) {
                if ((mode == 1 && getUser(s, ulist) == null)
                        || (mode == 2) && getUser(s, ulist) != null) {
                    break;
                }
            }
            System.err.println(err);
        }
        return s;
    }

    public static User getUser(String s, List<User> ulist) {
        for (User u : ulist) {
            if (u.getUsername().equals(s)) {
                return u;
            }
        }
        return null;
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

    public static boolean checkPass(String opass, String npass) {
        boolean check = false;
        while (!check) {
            if (opass.equals(npass)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public static String md5Hash(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] hashBytes = md.digest(s.getBytes());

            BigInteger no = new BigInteger(1, hashBytes);

            String hastxt = no.toString(16);
            while (hastxt.length() < 32) {
                hastxt = "0" + hastxt;
            }
            return hastxt;

        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static boolean validateMD5(String s, String store) {
        String MD5pass = md5Hash(s);
        return store.equals(MD5pass);
    }
}
