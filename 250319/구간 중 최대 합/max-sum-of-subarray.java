import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int lp = 0;
        int rp = lp + k - 1;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = lp; i <= rp; i++) {
            sum += arr[i];
        }
        max = Math.max(max, sum);
        while(true) {
            sum -= arr[lp];
            rp++;
            if(rp == n) break;
            sum += arr[rp];
            max = Math.max(max, sum);
            lp++;
        }
        System.out.print(max);
    }
}