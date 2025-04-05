

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int answer = 0;
    // 0 : garo, 1: sero, 2: degak
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        visited[0][0] = true;
        visited[0][1] = true;
        dfs(0, 1, 0);

        System.out.print(answer);
    }

    private static void dfs(int y, int x, int direct) {
//        System.out.println("y : " + y + " x : " + x);
        if(y == n - 1 && x == n - 1) {
            answer++;
            return;
        }
//        printVisited();


        if(direct != 1 && !checkRange(y, x + 1) && !visited[y][x + 1] && arr[y][x + 1] != 1) {
            visited[y][x + 1] = true;
            dfs(y, x + 1, 0);
            visited[y][x + 1] = false;
        }
        if(direct != 0 && !checkRange(y + 1, x) && !visited[y + 1][x] && arr[y + 1][x] != 1) {
            visited[y + 1][x] = true;
            dfs(y + 1, x, 1);
            visited[y + 1][x] = false;
        }
        if(!checkRange(y + 1, x + 1) && !checkRange(y, x + 1) && !checkRange(y + 1, x) && !visited[y + 1][x+ 1] && arr[y + 1][x+ 1] != 1 && arr[y][x + 1] != 1 && arr[y + 1][x] != 1) {
            visited[y + 1][x] = true;
            dfs(y + 1, x + 1, 2);
            visited[y + 1][x] = false;
        }

    }

    private static boolean checkRange(int y, int x) {
        return y < 0 || x < 0 || y >= n || x >= n;
    }

    private static void printVisited() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }


}



