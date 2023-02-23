
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author quang
 */
public class Function {
    
    public void add(ArrayList<Person> list, String name, String adress,double salary){
        Person p = new Person(name, adress, salary);
        list.add(p);
    }
    
    
    public void display(ArrayList<Person> list){
        if (list.size()>1) 
    {
        for (int x=0; x<list.size(); x++) 
        {
            for (int i=0; i < list.size()-i; i++) {
                if (list.get(i).compareTo(list.get(i+1)) > 0)
                {
                    Person temp = list.get(i);
                    list.set(i,list.get(i+1) );
                    list.set(i+1, temp);
                }
            }
        }
    }

        for (Person p: list){
            System.out.println("\nInformation of Person you have entered: ");
            System.out.println(p.toString());
        }
    }
}
