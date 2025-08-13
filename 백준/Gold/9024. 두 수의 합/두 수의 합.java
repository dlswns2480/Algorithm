

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st2.nextToken());
            int k = Integer.parseInt(st2.nextToken());
            int[] arr = new int[n];
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st3.nextToken());
            }
            Arrays.sort(arr);

            int minDiff = Integer.MAX_VALUE;

            int lt = 0; int rt = n - 1;
            int answer = 0;
            while (lt < rt) {
                int sum = arr[lt] + arr[rt];
                int diff = Math.abs(sum - k);
                if (diff <= minDiff) {
                    if (diff < minDiff) answer = 0;
                    answer++;
                    minDiff = diff;
                }


                if (sum < k) lt++;
                else rt--;
            }
            sb.append(answer).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
