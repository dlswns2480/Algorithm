import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        // Please write your code here.

        int max = 1;
        int cnt = 1;
        for(int i = 0; i < n; i++) {
            if(i == 0 || (arr[i] * arr[i - 1] < 0)) {
                max = Math.max(max, cnt);
                cnt = 1;
                continue;
            }
            cnt++;
        }
        max = Math.max(max, cnt);
        System.out.print(max);
    }
}