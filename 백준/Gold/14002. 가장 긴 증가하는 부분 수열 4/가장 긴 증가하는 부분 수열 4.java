
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
        dp[0] = 1;
        String[] answers = new String[n];
        answers[0] = String.valueOf(arr[0]);
        for(int i = 1; i < arr.length; i++){
            int max = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(arr[i] > arr[j] && dp[j] > max) {
                    max = dp[j];
                    answers[i] = answers[j] + " " + arr[i];
                }
            }
            if(max == 0){
                answers[i] = String.valueOf(arr[i]);
            }
            dp[i] = max + 1;
        }
        int maxPrice = Arrays.stream(dp).max().getAsInt();
        int index = 0;
        for(int i = 0; i < dp.length; i++){
            if(dp[i] == maxPrice){
                index = i;
                break;
            }
        }
        System.out.println(maxPrice);
        System.out.print(answers[index].trim());
    }




}