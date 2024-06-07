

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<String> answers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(j, i, 1, arr[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.print(max);

    }

    private static void dfs(int x, int y, int L, int sum) {
        if(L == 4) {
            max = Math.max(max, sum);
            return;
        }
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= m || ny >= n || visited[ny][nx]) continue;
            if(L == 2) {
                visited[ny][nx] = true;
                dfs(x, y, L + 1, sum + arr[ny][nx]);
                visited[ny][nx] = false;
            }
            visited[ny][nx] = true;
            dfs(nx, ny, L + 1, sum + arr[ny][nx]);
            visited[ny][nx] = false;
        }

    }


}