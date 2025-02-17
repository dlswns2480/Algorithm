

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }
        max = Math.max(max, sum);
        int lp = 0;
        int rp = k - 1;
        while(rp < n) {
            sum -= arr[lp];
            lp++;
            rp++;
            if(rp >= n) break;
            sum += arr[rp];
            max = Math.max(max, sum);
        }
        System.out.print(max);

    }



}

