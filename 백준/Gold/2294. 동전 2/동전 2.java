

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coin = new int[n];
        int[] dp = new int[k + 1];
        for(int i = 1; i <= k; i++) dp[i] = 100_000;
        for(int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            for(int j = coin[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j - coin[i]] + 1, dp[j]);
            }
        }
//        for (int i = 0; i <= k; i++) {
//            System.out.print(dp[i] + ", ");
//        }
        if(dp[k] >= 100_000){
            System.out.print(-1);
            return;
        }
        System.out.print(dp[k]);



    }


}