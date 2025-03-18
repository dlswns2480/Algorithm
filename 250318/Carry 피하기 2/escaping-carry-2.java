import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(i != j && j != k && i != k) {
                        boolean carry = false;
                        int first = arr[i];
                        int sec = arr[j];
                        int third = arr[k];
                        int sum = first + sec + third;
                        if(first % 10 + sec % 10 + third % 10 >= 10) carry = true;
                        if(first % 100 / 10 + sec % 100 / 10 + third % 100 / 10 >= 10) carry = true;
                        if(first % 1000 / 100 + sec % 1000 / 100 + third % 1000 / 100 >= 10) carry = true;
                        if(first % 10000 / 1000 + sec % 10000 /1000 + third % 10000 / 1000 >= 10) carry = true;
                        if(!carry) answer = Math.max(answer, sum);
                    }
                }
            }
        }
        if(answer < 0) {
            System.out.print(-1);
            return;
        }
        System.out.print(answer);
        // Please write your code here.
    }
}