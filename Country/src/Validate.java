
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Scanner;

public class Validate {

    Scanner sc = new Scanner(System.in);
    
    public int getChoice() {
        int choice = 0;
        while (true) {
            try {
                System.out.print("input choice: ");
                    choice = sc.nextInt();
                    sc.nextLine();
                if (choice >= 1 && choice <= 5) {
                    break;
                }

            } catch (Exception e) {
                sc.nextLine();
                System.err.println("invalid choice, please input again");
            }
        }
        return choice;
    }

    public String getCode(ArrayList<EastAsiaCountries> list) {
        while (true) {
            boolean check = true;
            System.out.print("input code: ");
            String code = sc.nextLine();
            if (code.isEmpty()) {
                System.err.println("code cannot ve empty");
                continue;
            }
            for (EastAsiaCountries o : list) {
                if (o.getCountryCode().equalsIgnoreCase(code)) {
                    check = false;
                    System.err.println("dublicate code, please input again");
                    break;
                }
            }
            if (check) {
                return code;
            } 
        }
    }

    public String getName(ArrayList<EastAsiaCountries> list) {
        while (true) {
            System.out.print("input name: ");
            String name = sc.nextLine();
            if (name.isEmpty()) {
                System.err.println("name cannot be empty");
                continue;
            }
            if (!name.isEmpty()) {
                return name;
            }
        }
    }
  
    public float getArea(ArrayList<EastAsiaCountries> list) {
        float area;
        while (true) {
            try {
                System.out.print("input area: ");
                area = sc.nextFloat();
                sc.nextLine();
                if (area <= 0) {
                System.err.println("Area cannot be 0 and negative");
                continue;
                } else {
                    break;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.err.println("invalid area, please input again");    
            }
        }
        return area;
    }        

    public String getTerrain(ArrayList<EastAsiaCountries> list) {
        while (true) {
            System.out.print("input terrain: ");
            String terrain = sc.nextLine();
            if (terrain.isEmpty()) {
                System.err.println("terrain cannot be empty");
                continue;
            }
            if (!terrain.isEmpty()) {
                return terrain;
            }
        }
    }

}
