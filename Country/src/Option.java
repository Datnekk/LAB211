
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Option {

    
    public void add(ArrayList<EastAsiaCountries> list,String code, String name, 
            float area, String terrain){
        EastAsiaCountries e = new EastAsiaCountries(terrain, code, name, area);
        list.add(e);
    }
    public void display(ArrayList<EastAsiaCountries> list,String code){
        for (EastAsiaCountries o : list) {
            if(o.getCountryCode().equalsIgnoreCase(code)){
                o.display();
            }
        }
    }
    public void sort(ArrayList<EastAsiaCountries> list) {
        Collections.sort(list, new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
                return o1.getCountryName().compareToIgnoreCase(o2.getCountryName());
            }
        });
        for (EastAsiaCountries o : list) {
            o.display();
        }
    }
    public void search(ArrayList<EastAsiaCountries> list, String name){
        boolean check = true;
        for (EastAsiaCountries o : list) {
            if(o.getCountryName().equalsIgnoreCase(name)){
                o.display();
                check = false;
            }
        }
        if(check){
            System.out.println("not found");
        }
    }
}
