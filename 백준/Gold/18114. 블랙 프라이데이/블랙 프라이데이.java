

import java.io.*;
import java.util.*;


public class Main {
    static int n, c;
    static boolean[] visited;
    static int[] arr;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        n = Integer.parseInt(init[0]);
        c = Integer.parseInt(init[1]); // 맞춰야되는 무게
        List<Integer> arr = new ArrayList<>();
        visited = new boolean[n];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(line[i]));
            if (arr.get(i) == c) {
                System.out.print(1);
                return;
            }
        }
        Collections.sort(arr);
        int lt = 0; int rt = n - 1;

        while (lt < rt) {
            int sum = arr.get(lt) + arr.get(rt);
            if (sum == c) {
                System.out.print(1);
                return;
            }

            if (sum > c) {
                rt--;
            } else {
                if (arr.indexOf(c - sum) > lt && arr.indexOf(c - sum) < rt) {
                    System.out.print(1);
                    return;
                }
                lt++;
            }
        }

        System.out.print(0);
    }


}
