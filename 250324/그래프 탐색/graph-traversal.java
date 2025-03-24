import java.util.Scanner;
public class Main {
    static int cnt = 0;
    static int n;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int first = sc.nextInt();
            int sec = sc.nextInt();
            arr[first][sec] = arr[sec][first] = 1;
        }

        dfs(1);
        System.out.print(cnt);
        // Please write your code here.
    }

    private static void dfs(int idx) {
        // if(visited[idx]) {
        //     cnt--;
        //     return;
        // }
        visited[idx] = true;
        for(int i = 1; i <= n; i++) {
            if(arr[idx][i] == 1 && !visited[i]) {
                cnt++;
                dfs(i);
            }
        }
    }
}