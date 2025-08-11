

import java.io.*;
import java.util.*;


public class Main {
    static int SIZE = 100_0000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        String[] line = br.readLine().split(" ");
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(line[i]);
        }

        for (int i = 1; i < n ; i++) {
            if (arr[i] > arr[i + 1]) {
                sum++;
            }
            dp[i] = sum;
        }
        dp[n] = sum;

        StringBuilder sb = new StringBuilder();

        int querySize = Integer.parseInt(br.readLine());
        for (int i = 0; i < querySize; i++) {
            String[] query = br.readLine().split(" ");
            int x = Integer.parseInt(query[0]);
            int y = Integer.parseInt(query[1]);
            if (x == y) {
                sb.append(0).append("\n");
                continue;
            }
            sb.append(dp[y - 1] - dp[x - 1]).append("\n");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);

        /**
         * 9
         * 1 2 3 3 4 1 10 8 1
         * 5
         * 1 3
         * 2 5
         * 4 7
         * 9 9
         * 5 9
         *
         * 0, 0, 1, 0, 3
         */
    }
}
