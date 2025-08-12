

import java.io.*;
import java.util.*;


public class Main {
    static int SIZE = 100_0000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] init = br.readLine().split(" ");
        int[] arr = new int[n + 1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(init[i]);
            arr[i + 1] = sum;
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            sb.append(arr[end] - arr[start - 1]).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);

    }
}
