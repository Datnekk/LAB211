import java.util.Scanner;
import java.util.Random;
public class BinarySearch {

    int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            return binarySearch(arr, mid + 1, r, x);
        }

        return -1;
    }
    
    public void displayArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
    
    private static int checkInputArray(String msg){
            Scanner scanner = new Scanner(System.in);
            String input;
            double arr_length;
            do{
                System.out.println(msg);
                input = scanner.nextLine();
                if(input.isEmpty()){
                    System.out.println("Input could not be empty.Please enter a positive integer number");
            }
                try {
                arr_length = Double.parseDouble(input);
                if (arr_length <= 0) {
                    throw new Exception();
                }
                if ((int) arr_length != arr_length) {
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
        return (int)arr_length;
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int length = checkInputArray("Enter number of array:");
        
          int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(length);
        }
        
        BinarySearch searcher = new BinarySearch();
        System.out.println("\nThe array: ");
        searcher.displayArray(array);
        
        int search = checkInputArray("\nEnter search value:");
         
        int foundIndex = searcher.binarySearch(array, 0, array.length-1, search);
            if(foundIndex==-1)
            System.out.println("\n"+search+" "+"not in the array");
        else
            System.out.println("\nFound " + search + " at index: " + foundIndex);      
    }
}