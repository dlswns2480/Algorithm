

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int node;
    static boolean[] visited;
    static int count = 0;
    static int[][] arr;
    static int line;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
        arr = new int[node + 1][node + 1];
        visited = new boolean[node + 1];
        for(int i = 0; i < line; i++){
            String[] str = br.readLine().split(" ");
            int n1 = Integer.parseInt(str[0]);
            int n2 = Integer.parseInt(str[1]);

            arr[n1][n2] = arr[n2][n1] = 1;
        }
        dfs(1);
        System.out.print(count - 1);

    }

    private static void dfs(int index) {
        visited[index] = true;

        count++;
        for(int i = 1; i <= node; i++){
            if(arr[index][i] == 1 && !visited[i]){
                dfs(i);
            }
        }

    }
}
