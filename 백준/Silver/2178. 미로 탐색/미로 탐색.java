

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static class Node {
        int y, x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        n = Integer.parseInt(num[0]);
        m = Integer.parseInt(num[1]);
        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs();
        System.out.print(arr[n-1][m-1]);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        visited = new boolean[n][m];
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node poll = q.poll();
                for(int j = 0; j < 4; j++) {
                    int ny = poll.y + dy[j];
                    int nx = poll.x + dx[j];
                    if(ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx]) continue;
                    if(ny == n - 1 && nx == m - 1) {
                        arr[ny][nx] = arr[poll.y][poll.x] + 1;
                        return;
                    }
                    if(arr[ny][nx] == 1) {
                        arr[ny][nx] = arr[poll.y][poll.x] + 1;
                        q.offer(new Node(ny, nx));
                    }
                }
            }
        }
    }


}

