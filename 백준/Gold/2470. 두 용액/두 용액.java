

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(arr);

        int lp = 0;
        int rp = n - 1;

        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while (lp < rp) {
            int sum = arr[lp] + arr[rp];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer[0] = arr[lp];
                answer[1] = arr[rp];
            }
            if (sum < 0) {
                lp++;
            } else {
                rp--;
            }
        }
        System.out.print(answer[0] + " " + answer[1]);
    }
}
