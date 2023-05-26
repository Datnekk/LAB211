
import java.util.HashMap;
import java.util.Map;
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String: ");
        String s = sc.nextLine();
        Map<Character, Integer> charCount = new HashMap<>();
        Map<String, Integer> wordCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                if (!charCount.containsKey(i)) {
                    charCount.put(s.charAt(i), 1);
                } else {
                    charCount.put(s.charAt(i), charCount.get(s.charAt(i)) + 1);
                }
            }
        }

        String[] arr = s.split("[!@#$%&*, ]");
        for (String o : arr) {
            if (!wordCount.containsKey(o)) {
                wordCount.put(o, 1);
            } else {
                wordCount.put(o, wordCount.get(o) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.print("{" + entry.getKey() + "=" + entry.getValue() + "}"+"\n");
        }

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.print("{" + entry.getKey() + "=" + entry.getValue() + "}");
        }
    }
}
