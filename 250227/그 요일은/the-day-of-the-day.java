import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();
        String[] yoil = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int[] dayOfMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int index = 0;
        for(int i = 0; i < 7; i++) {
            if(yoil[i].equals(A)){
                index = i;
                break;
            }
        }
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

        int count = 0;
        int diff = second - first;

        
        count += (diff / 7);
        int dayDiff = diff % 7;

        if(dayDiff >= index) {
            count++;
        }
        System.out.print(count);
        // Please write your code here.
    }
}