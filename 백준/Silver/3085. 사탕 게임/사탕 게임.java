

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static String[][] arr;
    static int n;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = line[j];
            }
        }
        count();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (!arr[i][j].equals(arr[ny][nx])) {
                        swap(i, j, ny, nx);
                        count();
                        swap(i, j, ny, nx);
                    }
                }
            }
        }
        System.out.print(max);
    }

    private static void swap(int i, int j, int ny, int nx) {
        String temp = arr[i][j];
        arr[i][j] = arr[ny][nx];
        arr[ny][nx] = temp;
    }

    private static void count() {

        // 행 먼저
        for(int i = 0; i < n; i++) {
            String start = arr[i][0];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (start.equals(arr[i][j])) {
                    cnt++;
                } else {
                    start = arr[i][j];
                    max = Math.max(max, cnt);
                    
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
        }

        // 열 카운트
        for (int i = 0; i < n; i++) {
            String start = arr[0][i];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (start.equals(arr[j][i])) {
                    cnt++;
                } else {
                    start = arr[j][i];
                    max = Math.max(max, cnt);

                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
        }
    }

}
