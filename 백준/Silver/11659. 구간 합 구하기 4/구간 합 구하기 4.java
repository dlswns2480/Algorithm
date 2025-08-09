

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        String[] nums = br.readLine().split(" ");
        int[] arr = new int[n + 1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(nums[i]);
            arr[i + 1] = sum;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] range = br.readLine().split(" ");
            int start = Integer.parseInt(range[0]);
            int end = Integer.parseInt(range[1]);
            sb.append(arr[end] - arr[start - 1]).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
