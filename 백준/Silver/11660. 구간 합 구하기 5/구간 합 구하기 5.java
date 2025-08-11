

import java.io.*;
import java.util.*;


public class Main {
    static int SIZE = 100_0000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int n = Integer.parseInt(init[0]);
        int m = Integer.parseInt(init[1]);
        int[][] arr = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];

        /**
         *
         * 2 4
         * 1 2
         * 3 4
         * 1 1 1 1
         * 1 2 1 2
         * 2 1 2 1
         * 2 2 2 2
         *
         * 1, 2, 3, 4
         *
         * 27, 6, 64
         */
        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        for (int i = 1; i <= n; i++) {
            dp[1][i] = dp[1][i - 1] + arr[1][i];
            dp[i][1] = dp[i - 1][1] + arr[i][1];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + arr[i][j];
            }
        }

        // 2,1  ~~ 3,2

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            int x2 = Integer.parseInt(line[2]);
            int y2 = Integer.parseInt(line[3]);
            if (x1 == x2 && y1 == y2) {
                sb.append(arr[x1][y1]).append("\n");
                continue;
            }
            sb.append(dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1]).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
