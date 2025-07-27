
import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, k;
    static boolean[][] visited = new boolean[501][501];
    static int[][] map = new int[501][501];
    static int[][] cost = new int[501][501];

    private static class Node {
        int y, x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int danger = Integer.parseInt(br.readLine());
        for (int i = 0; i < danger; i++) {
            String[] line = br.readLine().split(" ");
            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            int x2 = Integer.parseInt(line[2]);
            int y2 = Integer.parseInt(line[3]);

            int yStart = y1 > y2 ? y2 : y1;
            int yEnd = y2 > y1 ? y2 : y1;
            int xStart = x1 > x2 ? x2 : x1;
            int xEnd = x1 > x2 ? x1 : x2;


            for (int j = yStart; j <= yEnd; j++ ) {
                for (int k = xStart; k <= xEnd; k++) {
                    map[j][k] = 1;
                }
            }
        }

        int death = Integer.parseInt(br.readLine());
        for (int i = 0; i < death; i++) {
            String[] line = br.readLine().split(" ");
            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            int x2 = Integer.parseInt(line[2]);
            int y2 = Integer.parseInt(line[3]);

            int yStart = y1 > y2 ? y2 : y1;
            int yEnd = y2 > y1 ? y2 : y1;
            int xStart = x1 > x2 ? x2 : x1;
            int xEnd = x1 > x2 ? x1 : x2;


            for (int j = yStart; j <= yEnd; j++ ) {
                for (int k = xStart; k <= xEnd; k++) {
                    map[j][k] = 2;
                }
            }
        }
        bfs();
        if (cost[500][500] == Integer.MAX_VALUE) {
            System.out.print(-1);
            return;
        }
        System.out.print(cost[500][500]);
    }

    private static void bfs() {
        Deque<Node> que = new LinkedList<>();
        que.add(new Node(0, 0));
        visited[0][0] = true;

        for (int i = 0; i <= 500; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }

        cost[0][0] = 0;

        while (!que.isEmpty()) {
            Node curr = que.poll();
            for (int i = 0; i < 4; i++) {
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];
                if (nx < 0 || ny < 0 || nx >= 501 || ny >= 501 || visited[ny][nx]) continue;
                if (map[ny][nx] == 2) continue;

                int life = cost[curr.y][curr.x] + map[ny][nx];
                if(life < cost[ny][nx]) {
                    cost[ny][nx] = life;
                    if (map[ny][nx] == 1) {
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
