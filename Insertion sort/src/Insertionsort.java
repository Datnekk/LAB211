
import java.util.Random;
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
public class Insertionsort {

   
    public static void main(String[] args) {
        
        int size_array = InputPositiveNumber("input size of the array: ");
        
        int[] array = CreateArray(size_array);
        boolean test = false;
        Display(array, "Unsorted array: ");
        insertionSort(array, test);
        Display(array, "Sorted array: ");
        
    }
    
     private static int InputPositiveNumber(String msg) {
        Scanner sc = new Scanner(System.in);
        double size_array;
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input could not be empty. Please enter a positive integer number");
                continue;
            }
            try {
                size_array = Double.parseDouble(input);
                if (size_array <= 0) {
                    throw new Exception();
                }
                if ((int) size_array != size_array) {
                    throw new Error();
                } else {
                    break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Input could not be a string. Please enter a positive integer number");
                continue;
            } catch (Exception NegaError) {
                System.out.println("Input could not be less than zero. Please enter a positive integer number");
                continue;
            } catch (Error RealNumError) {
                System.out.println("Input could not be a real number. Please enter a positive integer number");
                continue;
            }
        } while (true);
        return (int) size_array;
    }

    private static int[] CreateArray(int size_array) {
        int[] array = new int[size_array];
        Random rd = new Random();
        for (int i = 0; i < size_array; i++) {
            array[i] = rd.nextInt(size_array);
        }
        return array;
    }

    private static void Display(int[] array, String msg) {
        System.out.print(msg);
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        if(msg.equals("Unsorted array: ")){
            System.out.println("]");
        }else{
            System.out.print("]");
        }
    }

    private static void insertionSort(int[] arr, boolean test)
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

}
