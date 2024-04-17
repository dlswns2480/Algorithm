

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] conn;
    static int user;
    static int edge;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        user = sc.nextInt();
        edge = sc.nextInt();
        conn = new int[user + 1][user + 1];
        int minValue = Integer.MAX_VALUE;
        int minIndex = 0;
        int[] answer = new int[user + 1];
        for(int i = 1; i <= edge; i++){
            int first =  sc.nextInt();
            int second = sc.nextInt();
            conn[first][second] = conn[second][first] = 1;
        }

        for(int i = 1; i <= user; i++){
            answer[i] = bfs(i);
//            System.out.println(answer[i]);
            if(answer[i] < minValue){
                minIndex = i;
                minValue = answer[i];
            }
        }

        System.out.print(minIndex);
    }

    private static int bfs(int root) {
        boolean[] visited = new boolean[user + 1];
        Queue<Integer> que = new LinkedList<>();
        visited[root] = true;
        que.offer(root);
        int sum = 0;
        int L = 0;

        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++){
                int poll = que.poll();
                for(int j = 1; j <= user; j++){
                    if(!visited[j] && conn[poll][j] == 1){
                        sum += (++L);
                        visited[j] = true;
                        que.offer(j);
                    }
                }
            }
            L++;
        }

        return sum;
    }
}