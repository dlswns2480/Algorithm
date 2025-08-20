

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[][] arr = new int[26][str.length()];

        int firstId = str.charAt(0) - 'a';
        arr[firstId][0] = 1;

        for (int i = 1; i < str.length(); i++) {
            int id = str.charAt(i) - 'a';
            arr[id][i] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j - 1] == 0) continue;
                if (arr[i][j] == 1 && arr[i][j - 1] != 0) {
                    arr[i][j] = arr[i][j - 1] + 1;
                } else if (arr[i][j] == 0) {
                    arr[i][j] = arr[i][j - 1];
                }
            }
        }



        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String[] query = br.readLine().split(" ");
            char c = query[0].charAt(0);
            int l = Integer.parseInt(query[1]);
            int r = Integer.parseInt(query[2]);

            int id = c - 'a';
            if (l == 0) {
                sb.append(arr[id][r]).append("\n");
                continue;
            }
            int result = arr[id][r] - arr[id][l - 1];
            sb.append(result).append("\n");
        }


        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
