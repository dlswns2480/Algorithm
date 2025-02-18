

import java.io.*;
import java.util.*;

public class Main {
    static int g, s;
    static int N;
    static int[][] arr;
    static int height;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                max = Math.max(max, arr[i][j]);
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i <= max; i++) {
            height = i;
            visited = new boolean[N][N];
            int count = 0;
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    if(visited[j][k]) continue;
                    if(arr[j][k] > height) {
                        count++;
                        dfs(j, k);
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.print(answer);
    }

    private static void dfs(int y, int x) {
        if(visited[y][x]) return;
        visited[y][x] = true;
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            if(arr[ny][nx] > height) {
                dfs(ny, nx);
            }
        }
    }


}

