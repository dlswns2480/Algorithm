

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int a,b,c;
    static boolean[] visited;
    static int n;
    static int[] arr;
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        for(int i = 1; i <= n; i++) arr[i] = sc.nextInt();
        if(n == 1) {
            System.out.print(0);
            return;
        }
        bfs(1);
        System.out.print(answer);
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;
        int L = 0;
        while(!que.isEmpty()) {
            int size = que.size();

            for(int j = 0; j < size; j++){
                int curr = que.poll();
                for(int i = curr + 1; i <= curr + arr[curr]; i++){
                    if(i == n){
                        answer = L + 1;
                        return;
                    }

                    if(!visited[i]){
                        visited[i] = true;
                        que.offer(i);
                    }
                }
            }
            L++;
        }
    }


}