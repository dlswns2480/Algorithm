import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int n;
    static int m;
    static boolean isTop;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && arr[i][j] != 0){
                    isTop = true;
                    dfs(i, j);
                    if(isTop) {
                        answer++;
                    }
                }
            }
        }
        System.out.print(answer);
    }

    private static void dfs(int n1, int m1) {
        visited[n1][m1] = true;
        for(int i = 0; i < 8; i++){
            int nextN = n1 + dx[i];
            int nextM = m1 + dy[i];
            if(nextN < 0 || nextM < 0 || nextN >= n || nextM >= m) continue;
            if(arr[n1][m1] < arr[nextN][nextM]){
                isTop = false;
            }
            if(arr[n1][m1] == arr[nextN][nextM] && !visited[nextN][nextM]) {
                dfs(nextN, nextM);
            }

        }
    }


}