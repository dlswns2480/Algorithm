

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> results = new ArrayList<>();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int sticker = Integer.parseInt(br.readLine());
            int[][] arr = new int[sticker][2];
            String[] first = br.readLine().split(" ");
            String[] second = br.readLine().split(" ");
            for(int j = 0; j < first.length; j++){
                arr[j][0] = Integer.parseInt(first[j]);
                arr[j][1] = Integer.parseInt(second[j]);
            }
            results.add(getMaxScore(arr));
        }
        for(int i = 0; i < results.size() - 1; i++){
            System.out.println(results.get(i));
        }
        System.out.print(results.get(results.size() - 1));
    }

    private static int getMaxScore(int[][] arr){
        int[][] dp = new int[arr.length][2];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        int max = Math.max(dp[0][0], dp[0][1]);
        if(arr.length > 1){
            dp[1][0] = dp[0][1] + arr[1][0];
            dp[1][1] = dp[0][0] + arr[1][1];
            max = Math.max(max, Math.max(dp[1][0], dp[1][1]));
        }
        
        for(int i = 2; i < arr.length; i++){
            dp[i][0] = Math.max(dp[i - 1][1] + arr[i][0], dp[i - 2][1] + arr[i][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + arr[i][1], dp[i - 2][0] + arr[i][1]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        return max;
    }
}