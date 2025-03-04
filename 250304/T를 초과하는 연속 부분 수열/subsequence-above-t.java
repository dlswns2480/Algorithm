import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        int max = 0;
        int cnt = 0;
        if(arr[0] <= t) {
            cnt = 0;
            max = 0;
        } else {
            max = 1;
            cnt = 1;
        }
        for(int i = 0; i < n; i++) {
            if(i == 0 || arr[i] <= t) {
                max = Math.max(max, cnt);
                cnt = 0;
                continue;
            }
            cnt++;
        }
        max = Math.max(cnt, max);
        if(max == 0) {
            System.out.print(0);
        } else {
            System.out.print(max);
        }
    }
}