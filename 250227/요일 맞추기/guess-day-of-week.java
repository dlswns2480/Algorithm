import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.
        int[] dayOfMonth = {0, 31, 28, 31,30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] plusyoill = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        String[] minusyoill = {"Mon", "Sun", "Sat", "Fri", "Thu", "Wed", "Tue"};

        int first = 0;
        for(int i = 0; i < m1; i++) {
            first += dayOfMonth[i];
        }
        first += d1;

        int second = 0;
        for(int i = 0; i < m2; i++) {
            second += dayOfMonth[i];
        }
        second += d2;

        int diff = second - first;
        int idx = 0;
        if(diff < 0) {
            idx = Math.abs(diff) % 7;
            System.out.print(minusyoill[idx]);
            return;
        }
        idx = diff % 7;

        System.out.print(plusyoill[idx]);


    }
}