
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author quang
 */
public class compareDate {
    public static void main(String[] args) {
        for (int i=0; i<=2; i++){
            getDate();
        }
    }
    
     public static String getDate() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        df.setLenient(false);
        Date date;
        while (true) {
            try {
                System.out.print("Please enter date with format [dd/mm/yyyy]: ");
                date = df.parse(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("invalid date,please input again: ");
            }
        }
        return df.format(date);
    }
     
}
