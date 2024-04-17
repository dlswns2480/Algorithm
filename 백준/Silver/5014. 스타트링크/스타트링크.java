

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int f;
    static int s;
    static int g;
    static int u;
    static int d;
    static int[] dx = new int[2];
    static boolean[] visited;
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        f = sc.nextInt(); // height
        s = sc.nextInt(); // now loc
        g = sc.nextInt(); // target
        dx[0] = sc.nextInt();
        dx[1] = sc.nextInt() * -1;
        visited = new boolean[f + 1];

        bfs(s);
        if(answer == -1) {
            System.out.print("use the stairs");
            return;
        }
        System.out.print(answer);
    }

    private static void bfs(int root) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(root);
        visited[root] = true;
        int L = 0;
        if(root == g) {
            answer = 0;
            return;
        }
        while (!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++){
                int poll = que.poll();
                for(int j = 0; j < 2; j++){
                    int curr = poll + dx[j];
                    if(curr == g) {
                        answer = L + 1;
                        return;
                    }
                    if(curr >= 1 && curr <= f && !visited[curr]){
                        visited[curr] = true;
                        que.offer(curr);
                    }
                }
            }
            L++;
        }
    }
}