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
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(i == 0 || arr[i] != arr[i - 1]) {
                max = Math.max(max, ++cnt);
                cnt = 0;
                continue;
            }
            cnt++;
        }
        max = Math.max(cnt, max);
        System.out.print(max);
        // Please write your code here.
    }
}