

import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] map;
    static int[][] dist;
    static class Node {
        int y, x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        m = Integer.parseInt(split[0]); // garo
        n = Integer.parseInt(split[1]); // sero
        map = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        bfs();
        
        System.out.print(dist[n - 1][m - 1]);
    }

    private static void bfs() {
        Deque<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        queue.offer(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue; // 범위 체크
                int cost = dist[curr.y][curr.x] + map[ny][nx];

                if (cost < dist[ny][nx]) {
                    if (map[ny][nx] == 1) {
                        dist[ny][nx] = cost;
                        queue.addLast(new Node(ny, nx));
                    } else {
                        dist[ny][nx] = cost;
                        queue.addFirst(new Node(ny, nx));
                    }
                }
            }

        }
    }


}
