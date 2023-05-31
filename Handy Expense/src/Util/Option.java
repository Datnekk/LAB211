/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import OBJ.Expenses;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quang
 */
public class Option {

    List<Expenses> elist;

    public Option() {
        elist = new ArrayList<>();
    }

    public void add() {
        int id = Validation.getId(elist);
        String date = Validation.getDate("Enter Date: ");
        double amount = Validation.getDouble("Enter Amount: ", 0, Double.MAX_VALUE);
        String content = Validation.getString("Enter content: ");
        
        elist.add(new Expenses(id, date, amount, content));
    }

    public void diplayElist() {
        System.out.println("Id    Date       Amount         Content");
        diplay(elist);
        int total = Validation.getTotal(elist);
        System.out.println("Total: " +total);
    }

    private void diplay(List list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public void delete() {
        int id = Validation.getInt("Enter id: ", 1, Integer.MAX_VALUE);
        Expenses e = Validation.getExpenses(id, elist);
        if (Validation.getExpenses(id, elist) == null) {
            System.out.println("Not Found");
        } else {
            elist.remove(e);
            System.out.println("Remove Successfully !!");
        }
        diplayElist();
    }

}
