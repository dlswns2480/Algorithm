

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n; //node size
    static int m; // want node pair size
    static int[][] arr;
    static int start;
    static int end;
    static List<Integer> answer = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n + 1][n + 1];

        for(int i = 0; i < n - 1; i++){
            int first = sc.nextInt();
            int second = sc.nextInt();
            int dist = sc.nextInt();
            arr[first][second] = arr[second][first] = dist;
        }

        for(int i = 0; i < m; i++){
            visited = new boolean[n + 1];
            start = sc.nextInt();
            end = sc.nextInt();
            bfs(start, 0);
        }

        for(int x : answer) {
            System.out.println(x);
        }


    }

    private static void bfs(int s, int distance) {
        visited[s] = true;
        if(s == end) {
            answer.add(distance);
            return;
        }
        else{
            for(int i = 1; i <= n; i++){
                if(!visited[i] && arr[s][i] != 0){
                    bfs(i, distance + arr[s][i]);
                }
            }
        }
    }


}