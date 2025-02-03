

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        long answer = 0;
        int n = sc.nextInt();
        long m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            int height = sc.nextInt();
            arr[i] = height;
        }
        Arrays.sort(arr);
        long lt = 1;
        long rt = arr[arr.length - 1] - 1;
        while(lt <= rt) {
            long mid = (lt + rt) / 2;
            long sum = 0;
            for(int i = 0; i < arr.length; i++) {
                long diff = arr[i] - mid;
                if(diff > 0) sum += diff;
            }

            if(sum >= m) {
                lt = mid + 1;
                answer = mid;
            } else {
                rt = mid - 1;
            }
        }
        System.out.print(answer);
    }


}

