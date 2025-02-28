import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        int[] arr = new int[binary.length()];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(String.valueOf(binary.charAt(i)));
        }

        int idx = arr.length;
        int num = 0;
        for(int i = idx - 1; i >= 0; i--) {
            num += (arr[i] * Math.pow(2, i));
        }

        System.out.print(num);
        // Please write your code here.
    }
}