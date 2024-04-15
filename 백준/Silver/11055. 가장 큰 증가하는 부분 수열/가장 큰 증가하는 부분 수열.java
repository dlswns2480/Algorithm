
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int prevPercent;
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        dp[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            int max = 0;
            for(int j = i - 1; j >= 0; j--){
                if(arr[i] > arr[j] && dp[j] > max){
                    max = dp[j];
                }
            }
            dp[i] = max + arr[i];
        }
        Arrays.sort(dp);
        System.out.print(dp[dp.length - 1]);






    }




}