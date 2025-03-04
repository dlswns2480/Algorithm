import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int num = arr[0];
        int cnt = 1;
        for(int i = 1; i < n; i++) {
            if(arr[i] != num) {
                max = Math.max(max, cnt);
                cnt = 1;
                num = arr[i];
                continue;
            }
            cnt++;
        }

        System.out.print(max);
        // Please write your code here.
    }
}