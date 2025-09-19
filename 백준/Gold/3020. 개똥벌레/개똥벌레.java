

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);

        int[] wallChanged = new int[h + 2];

        boolean isSeoksun = true;
        for (int i = 0; i < n; i++) {
            int length = Integer.parseInt(br.readLine());
            if (isSeoksun) {
                wallChanged[1] += 1;
                wallChanged[length + 1] -= 1;
            } else {
                wallChanged[h - length + 1] += 1;
                wallChanged[h + 1] -= 1;
            }
            isSeoksun = !isSeoksun;
        }
//        for (int i = 1; i <= h; i++) {
//            System.out.print(wallChanged[i] + " ");
//        }
//        System.out.println();

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= h; i++) {
            wallChanged[i] += wallChanged[i - 1];
            if (wallChanged[i] < min) {
                min = wallChanged[i];
            }
        }

        int count = 0;

        for (int i = 1; i <= h; i++) {
            if (wallChanged[i]== min) {
                count++;
            }
        }
        System.out.print(min + " " + count);
    }
}