
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class ManageEastAsiaCountries {

    public void menu() {
        System.out.println("1. Enter the information for 11 countries in Southeast Asia");
        System.out.println("2. Display the information of country you've just input.");
        System.out.println("3. Search the country according to the entered country's name.");
        System.out.println("4. Display the information increasing with the country name.");
        System.out.println("5. Exit.");
    }

    public static void main(String[] args) {
        int choice;
        Validate v = new Validate();
        ManageEastAsiaCountries m = new ManageEastAsiaCountries();
        Option o = new Option();
        ArrayList<EastAsiaCountries> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String code = "";
        String name = "";
        float area;
        while (true) {
            m.menu();
            choice = v.getChoice();
            switch (choice) {
                case 1:
                    code = v.getCode(list);
                    name = v.getName(list);
                    area = v.getArea(list);
                    System.out.print("input terrain: ");
                    String terrain = sc.nextLine();
                    o.add(list, code, name, area, terrain);
                    break;
                case 2:
                    if (!code.isEmpty()) {
                        o.display(list, code);
                    }
                    break;
                case 3:
                    System.out.print("input country name: ");
                    String countryName = sc.nextLine();
                    o.search(list, countryName);
                    break;
                case 4:
                    o.sort(list);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
