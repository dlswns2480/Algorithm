

import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static int n;
    static class Node {
        int y, x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dist = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs();

        System.out.print(dist[n - 1][n - 1]);
    }

    private static void bfs() {
        Deque<Node> que = new LinkedList<>();
        que.offer(new Node(0, 0));
        dist[0][0] = 0;
        visited[0][0] = true;

        while (!que.isEmpty()) {
            Node curr = que.poll();
            for (int i = 0; i < 4; i++) {
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[ny][nx]) continue;

                int cost = dist[curr.y][curr.x] + Math.abs(map[ny][nx] - 1);
                if (cost < dist[ny][nx]) {
                    dist[ny][nx] = cost;
                    if (map[ny][nx] == 0) {
                        visited[ny][nx] = true;
                        que.addLast(new Node(ny, nx));
                    } else {
                        visited[ny][nx] = true;
                        que.addFirst(new Node(ny, nx));
                    }
                }
            }
        }
    }


}
