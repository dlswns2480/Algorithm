

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int h = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        String[][] arr = new String[h][w];
        int[][] answer = new int[h][w];

        for(int i = 0; i < h; i++) {
            String[] clouds = br.readLine().split("");
            for(int j = 0; j < w; j++) {
                arr[i][j] = clouds[j];
            }
        }

        for(int i = 0; i < h; i++) {
            int arrive = -1;
            boolean flag = false;
            for(int j = 0; j < w; j++) {
                if(arr[i][j].equals("c")) {
                    flag = true;
                    arrive = 0;
                    answer[i][j] = arrive;
                    continue;
                }

                if(flag) {
                    arrive++;
                    answer[i][j] = arrive;
                    continue;
                }
                answer[i][j] = arrive;
            }
        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }

}

