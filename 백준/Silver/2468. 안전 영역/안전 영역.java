

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int n;
    static int[][] dead;
    static int max = 1;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> lst = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dead = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                lst.add(Integer.parseInt(s[j]));
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        for(int i = 1; i <= Collections.max(lst); i++){
            int result = safe(i);
            max = Math.max(max, result);
        }
        System.out.print(max);

    }

    private static int safe(int rain) {
        int cnt = 0;
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] <= rain){
                    dead[i][j] = -1;
                }
                else{
                    dead[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(dead[i][j] == 1 && !visited[i][j]){
                    cnt++;
                    dfs(i, j);
                }
            }
        }
        return cnt;

    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nowX = x + dx[i];
            int nowY = y + dy[i];
            if(nowX < 0 || nowY < 0 || nowX >= n || nowY >= n){
                continue;
            }
            if(dead[nowX][nowY] == 1 && !visited[nowX][nowY]){
                dfs(nowX, nowY);
            }
        }
    }


}
