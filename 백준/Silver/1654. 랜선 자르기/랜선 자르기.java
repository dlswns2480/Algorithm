

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int prevPercent;
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        long[] arr = new long[k];
        for(int i = 0; i < k; i++){
            arr[i] = in.nextLong();
        }

        Arrays.sort(arr);

        long lt = 1;
        long rt = arr[arr.length - 1];
        long answer = 0;
        while(lt <= rt){
            long mid = (lt + rt) / 2;
            long size = countLine(mid, arr);
            if(size < n){
                rt = mid - 1;
            }
            else {
                answer = mid;
                lt = mid + 1;
            }
        }

        System.out.print(answer);
    }

    private static long countLine(long mid, long[] arr) {
        long count = 0;
        for(long num : arr) {
            count += (num / mid);
        }
        return count;
    }


}