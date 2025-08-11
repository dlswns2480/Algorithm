

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int n = Integer.parseInt(init[0]);
        int x = Integer.parseInt(init[1]);

        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int lt = 0;
        int rt = lt + x - 1;
        if (rt > n) rt = n - 1;


        int sum = 0;
        for (int i = lt; i <= rt; i++) {
            sum += arr[i];
        }
        int max = sum;
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        sum -= arr[lt];
        rt++;
        lt++;

        while (rt < n) {
            sum += arr[rt];
            max = Math.max(max, sum);
            map.put(sum, map.getOrDefault(sum, 0) + 1);

            sum -= arr[lt];
            rt++;
            lt++;
        }
        if (max <= 0) {
            System.out.print("SAD");
            return;
        }

        System.out.println(max);
        System.out.print(map.getOrDefault(max, 0));
    }
}
