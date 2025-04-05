

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static int n;
    static boolean[] visited;
    static int answer = 0;
    static int root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int target = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        visited = new boolean[n];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
            if(arr[i] == -1) {
                root = i;
                continue;
            }
            map[arr[i]][i] = 1;
        }

        if(target == root) {
            System.out.print(0);
            return;
        }
        visited[target] = true;
        erase(target);
        visited = new boolean[n];
        visited[root] = true;
        dfs(root);
        System.out.print(answer);
    }

    private static void erase(int target) {
        for(int i = 0; i < n; i++) {
            map[i][target] = 0;
        }
        for(int i = 0; i < n; i++) {
            if(!visited[i] && map[target][i] == 1) {
                map[target][i] = 0;
                map[i][target] = 0;
                visited[i] = true;
                erase(i);
            }
        }
    }

    private static void dfs(int idx) {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i] && map[idx][i] == 1) {
                cnt++;
                visited[i] = true;
                dfs(i);
            }
        }

        if(cnt == 0) {
//            System.out.println("idx : " + idx);
            answer++;
        }
    }


}



