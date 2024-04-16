

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
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[arr.length - 1] - 1;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            long tree = height(mid, arr);

            if(tree >= m) {
                lt = mid + 1;
                answer = mid;
            }
            else{
                rt = mid - 1;
            }
        }
        System.out.print(answer);

    }

    private static long height(int mid, int[] arr){
        long count = 0;
        for(int num : arr) {
            if(mid >= num) continue;
            count += (num - mid);
        }
        return count;
    }


}