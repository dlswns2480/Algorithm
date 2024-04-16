

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int prevPercent;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }
        int max = Arrays.stream(arr).max().getAsInt();
        int lt = max;
        int rt = sum;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(count(mid, arr) > m){
                lt = mid + 1;
            }
            else{
                rt = mid - 1;
                answer = mid;
            }
        }
        System.out.print(answer);
    }

    private static int count(int mid, int[] arr) {
        int count = 1;
        int sum = 0;
        for(int num : arr) {
            if(sum + num > mid){
                sum = num;
                count++;
            }
            else sum += num;
        }
        return count;
    }


}