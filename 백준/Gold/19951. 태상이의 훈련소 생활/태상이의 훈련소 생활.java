

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int query = Integer.parseInt(input[1]);
        int[] arr = new int[n + 1];
        int[] changed = new int[n + 2];

        String[] arrStr = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(arrStr[i - 1]);
        }

        for (int i = 0; i < query; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int size = Integer.parseInt(line[2]);

            changed[a] += size;
            changed[b + 1] -= size;
        }

        for (int i = 1; i <= n; i++) {
            changed[i] += changed[i - 1];
            arr[i] += changed[i];
            System.out.print(arr[i] + " ");
        }

    }
}