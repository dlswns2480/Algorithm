import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // day = 24 * 60 = 1440m, 1h = 60m
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        // Please write your code here.
        int d1 = 11;
        int h1 = 11;
        int m1 = 11;

        int first = d1 * 1440 + h1 * 60 + m1;

        int d2 = A;
        int h2 = B;
        int m2 = C;

        int second = d2 * 1440 + h2 * 60 + m2;
        int answer = second - first;
        if(answer < 0) {
            System.out.println(-1);    
            return;
        }
        System.out.println(second - first);
    }
}