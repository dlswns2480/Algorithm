

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 1};
    static int n;
    static int k;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n =sc.nextInt();
        k = sc.nextInt();
        visited = new boolean[10_0001];

        bfs(n);
        System.out.print(answer);
    }

    private static void bfs(int root) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(root);
        visited[root] = true;
        int L = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++){
                int poll = que.poll();
                if(poll == k) {
                    answer = L;
                    return;
                }
                for(int j = 0; j < 3; j++){
                    int curr = 0;
                    if(j == 2){
                        curr = poll * 2;
                    }
                    else curr = poll + dx[j];
                    if(curr >= 0 && curr <= 10_0000 && !visited[curr]){
                        visited[curr] = true;
                        que.offer(curr);
                    }
                }
            }
            L++;
        }
    }
}