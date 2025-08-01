

import java.io.*;
import java.util.*;


public class Main {
    static long[] sin;
    static long[] ssun;
    static int n;
    static long min = Long.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sin = new long[n];
        ssun = new long[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            sin[i] = Integer.parseInt(split[0]);
            ssun[i] = Integer.parseInt(split[1]);
        }


        for (int i = 0; i < n; i++) {
            if (min == 0) break;
            visited[i] = true;
            dfs(sin[i], ssun[i], 0);
            visited[i] = false;
        }
        System.out.print(min);
    }

    private static void dfs(long sinElem, long ssunElem, int count) {

        min = Math.min(min, Math.abs(sinElem - ssunElem));

        if (count == n) {
            min = Math.min(min, Math.abs(sinElem - ssunElem));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs( sinElem * sin[i], ssunElem + ssun[i], count + 1);
            visited[i] = false;
        }
    }

}
