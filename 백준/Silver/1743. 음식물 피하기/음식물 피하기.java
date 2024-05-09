

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int m;
    static int[] dp;
    static int[][] arr;
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;
    static int cnt;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        int k = sc.nextInt();
        for(int i = 0; i < k; i++){
            int first = sc.nextInt();
            int sec = sc.nextInt();
            arr[first][sec] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    cnt = 1;
                    visited[i][j] = true;
                    dfs(i, j);
                    answer = Math.max(answer, cnt);
                }
            }
        }
        System.out.print(answer);
    }

    private static void dfs(int r, int c) {
        if(cnt > n * m){
            return;
        }
        for(int i = 0; i < 4; i++){
            int nx = c + dx[i];
            int ny = r + dy[i];
            if(nx < 1 || ny < 1|| nx > m || ny > n || visited[ny][nx]) continue;
            if(arr[ny][nx] == 1){
                visited[ny][nx] = true;
                cnt++;
                dfs(ny, nx);
            }
        }
    }


}