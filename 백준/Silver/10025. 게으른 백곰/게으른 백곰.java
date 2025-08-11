

import java.io.*;
import java.util.*;


public class Main {
    static int SIZE = 100_0000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int n = Integer.parseInt(init[0]);
        int k = Integer.parseInt(init[1]);
        int[] arr = new int[SIZE + 1];
        int iceMax = Integer.MIN_VALUE;
        int iceMaxIndex = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int quantity = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            arr[x] = quantity;
            if (quantity > iceMax) {
                iceMax = quantity;
                iceMaxIndex = x;
            }

        }


        int lt = 0;
        int rt = lt + (k * 2);
        if (rt > SIZE) rt = SIZE;
        int sum = 0;
        for (int i = lt; i <= rt; i++) {
            sum += arr[i];

        }
        int max = sum;
        sum -= arr[lt];
        lt++;
        rt++;

        while (rt <= SIZE) {
//            if (rt == SIZE + 1) break;
            sum += arr[rt];
            max = Math.max(max, sum);

            sum -= arr[lt];
            lt++;
            rt++;
        }
        System.out.print(max);
    }
}
