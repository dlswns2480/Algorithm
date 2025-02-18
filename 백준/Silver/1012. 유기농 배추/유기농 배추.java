

import java.io.*;
import java.util.*;

public class Main {
    static int g, s, vegetable;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testSize = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test = 0; test < testSize; test++) {
            int answer = 0;
            String[] input = br.readLine().split(" ");
            g = Integer.parseInt(input[0]);
            s = Integer.parseInt(input[1]);
            vegetable = Integer.parseInt(input[2]);
            arr = new int[s][g];
            visited = new boolean[s][g];
            for(int i = 0; i < vegetable; i++) {
                String[] position = br.readLine().split(" ");
                arr[Integer.parseInt(position[1])][Integer.parseInt(position[0])] = 1;
            }
            for(int i = 0; i < s; i++) {
                for(int j = 0; j < g; j++) {
                    if(visited[i][j]) continue;
                    if(arr[i][j] == 1) {
                        answer++;
                        dfs(i, j);
                    }
                }
            }

            sb.append(answer).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static void dfs(int y, int x) {
        if(visited[y][x]) return;
        visited[y][x] = true;
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nx < 0 || ny < 0 || nx >= g || ny >= s) continue;
            if(arr[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }
    }


}

