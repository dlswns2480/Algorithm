

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] check;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new int[n];
        check = new int[4];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for(int i = 0; i < 4; i++) {
            check[i] = scanner.nextInt();
        }

        dfs(arr[0], 1);
        System.out.println(max);
        System.out.print(min);
    }

    private static void dfs(int sum, int idx) {
        if(idx == n) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(check[i] > 0) {
                check[i]--;

                switch (i) {
                    case 0:
                        dfs(sum + arr[idx], idx + 1);
                        break;
                    case 1:
                        dfs(sum - arr[idx], idx + 1);
                        break;
                    case 2:
                         dfs(sum * arr[idx], idx + 1);
                         break;
                    case 3:
                        if(sum < 0) {
                            sum = Math.abs(sum);
                            sum = -1 * (sum / arr[idx]);
                        } else {
                            sum /= arr[idx];
                        }
                        dfs(sum, idx + 1);
                        break;

                }
                check[i]++;
            }
        }


    }

}

