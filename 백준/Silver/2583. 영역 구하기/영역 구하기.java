
import java.io.*;
import java.util.*;

public class Main {
    static int m, n, k;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int answer;
    static int width;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        arr= new int[m][n];
        visited = new boolean[m][n];
        for(int i = 0; i < k; i++) {
            String[] position = br.readLine().split(" ");
            int lx = Integer.parseInt(position[0]);
            int ly = Integer.parseInt(position[1]);
            int rx = Integer.parseInt(position[2]);
            int ry = Integer.parseInt(position[3]);
            for(int j = ly; j < ry; j++) {
                for(int k = lx; k < rx; k++) {
                    arr[j][k] = 1;
                }
            }
        }
        List<Integer> lst= new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 0 && !visited[i][j]) {
                    width = 0;
                    dfs(i, j);
                    lst.add(width);
                }
            }
        }
        Collections.sort(lst);
        System.out.println(lst.size());
        for(int i = 0; i < lst.size() - 1; i++) {
            System.out.print(lst.get(i) + " ");
        }
        System.out.print(lst.get(lst.size() - 1));
    }

    private static void dfs(int y, int x) {
        if(visited[y][x]) return;
        width++;
        visited[y][x] = true;
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nx < 0 || ny < 0|| nx >= n || ny >= m) continue;
            if(arr[ny][nx] == 0){
                dfs(ny, nx);
            }
        }
    }


}

