

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {

            Map<Integer, Integer> map = new HashMap<>();

            int n1 = Integer.parseInt(br.readLine());
            String[] input1 = br.readLine().split(" ");
            int n2 = Integer.parseInt(br.readLine());
            String[] input2 = br.readLine().split(" ");
            int[] arr1 = new int[n1];
            int[] arr2 = new int[n2];
            for (int i = 0; i < n1; i++) {
                arr1[i] = Integer.parseInt(input1[i]);
                map.put(arr1[i], 1);
            }
            for (int i = 0; i < n2; i++) {
                arr2[i] = Integer.parseInt(input2[i]);
                if (map.getOrDefault(arr2[i], 0) == 1) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }

        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}