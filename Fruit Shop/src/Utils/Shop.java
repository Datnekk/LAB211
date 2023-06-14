/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import OBJ.Fruit;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author quang
 */
public class Shop {

    private ArrayList<Fruit> flist;
    private Hashtable<String, ArrayList<Fruit>> hashtable;

    public Shop() {
        flist = new ArrayList<>();
        hashtable = new Hashtable<>();
    }

    public void create() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String name = Validation.getString("Enter Fruit Name: ");
            int id = Validation.getInt("Enter Fruit ID: ", 1, Integer.MAX_VALUE);
            double price = Validation.getDouble("Enter Fruit Price: ", 1, Double.MAX_VALUE);
            int quatity = Validation.getInt("Enter Fruit Quantity: ", 1, Integer.MAX_VALUE);
            String origin = Validation.getString("Enter Fruit Origin: ");

            flist.add(new Fruit(id, name, price, quatity, origin));
            System.out.println("Do you want to continue (Y/N)?");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                continue;
            } else {
                break;
            }
        }
    }

    public void shopping() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Fruit> listbought = new ArrayList<>();
        displayFruit();
        while (true) {
            int select = Validation.getInt("To order, Pls selects items: ", 1, Integer.MAX_VALUE);
            Fruit selectedFr = null;
            for (Fruit f : flist) {
                if (f.getId() == select) {
                    selectedFr = f;
                    System.out.println("You selected: " + f.getName());
                    break;
                }
            }
            if (selectedFr != null) {
                int quantity = Validation.getInt("Please input quantity: ", 1, Integer.MAX_VALUE);
                selectedFr.setQuantity(quantity);
                listbought.add(selectedFr);
            }
            System.out.println("Do you want to continue buying ? (Y/N)");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("N")) {
                break;
            }
        }
        if (!listbought.isEmpty()) {
            System.out.println(" Product | Quantity | Price | Amount");
            double total = 0;
            for (Fruit f : listbought) {
                double amount = f.getQuantity() * f.getPrice();
                System.out.printf("%-10s | %-12s | %-15s | %-10s \n",
                        f.getName(),
                        f.getQuantity(),
                        f.getPrice() + "$",
                        amount + "$");
                total += amount;
            }
            System.out.println("Total: " + total);

            String name = Validation.getString("Input your Name: ");
            hashtable.put(name, listbought);
            System.out.println();
            System.out.println("Input successfully !!!");
        }
    }

    public void displayFruit() {
        System.out.println("List of Fruit: ");
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        for (Fruit f : flist) {
            System.out.printf("%-10s | %-15s | %-12s |%-12s \n", f.getId(), f.getName(), f.getOrigin(), f.getPrice() + "$");

        }
    }

    public void view() {
        for (String name : hashtable.keySet()) {
            System.out.println("Customer: " + name);
            System.out.println("Product | Quantity | Price | Amount");
            double total = 0;
            for (Fruit f : flist) {
                System.out.printf("%-10s | %-15s | %-12s |-12s \n",
                        f.getName(),
                        f.getQuantity(),
                        f.getPrice() + "$",
                        f.getQuantity() * f.getPrice() + "$");
                total += f.getQuantity() * f.getPrice();
            }
            System.out.println("Total: " + total);
        }
    }

}
