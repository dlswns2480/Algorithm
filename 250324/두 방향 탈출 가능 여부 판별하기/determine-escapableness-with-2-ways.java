import java.util.Scanner;
public class Main {
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i][j] = sc.nextInt();
        
        dfs(0, 0);
        System.out.print(answer);
        // Please write your code here.
    }

    private static void dfs(int y, int x) {
        if(y == n - 1 && x == m - 1) {
            answer = 1;
            return;
        }

        for(int i = 0; i < 2; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx]) continue;
            if(arr[ny][nx] == 1) {
                visited[ny][nx] = true;
                dfs(ny, nx);
            }
        }
    }
}