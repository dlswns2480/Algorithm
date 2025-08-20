

import java.io.*;
import java.util.*;


public class Main {
    static int h, w;
    static int sh, sw, eh, ew;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static String[][] arr;
    static int[][] dist;
    static boolean[][] nearWall;

    static class Node {
        int y, x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        h = Integer.parseInt(init[0]);
        w = Integer.parseInt(init[1]);

        arr = new String[h][w];
        visited = new boolean[h][w];
        nearWall = new boolean[h][w];
        dist = new int[h][w];

        for (int i = 0; i < h; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < w; j++) {
                if (line[j].equals("S")) {
                    sh = i;
                    sw = j;
                } else if (line[j].equals("E")) {
                    eh = i;
                    ew = j;
                }
                arr[i][j] = line[j];
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                for (int k = 0; k < 4; k++) {
                    int nh = i + dy[k];
                    int nw = j + dx[k];
                    if (nh < 0 || nh >= h || nw < 0 || nw >= w) continue;
                    if (arr[nh][nw].equals("#")) {
                        nearWall[i][j] = true;
                        break;
                    }
                }
            }
        }

        bfs();
        System.out.print(dist[eh][ew]);
    }

    private static void bfs() {
        Deque<Node> que = new LinkedList<>();
        que.add(new Node(sh, sw));
        visited[sh][sw] = true;
        dist[sh][sw] = 0;

        while (!que.isEmpty()) {
            Node curr = que.poll();
            for (int i = 0; i < 4; i++) {
                int nh = curr.y + dy[i];
                int nw = curr.x + dx[i];
                if (nh < 0 || nh >= h || nw < 0 || nw >= w || visited[nh][nw] || arr[nh][nw].equals("#")) continue;

                if (nearWall[curr.y][curr.x] && nearWall[nh][nw]) {
                    if (dist[nh][nw] > dist[curr.y][curr.x]) {
                        dist[nh][nw] = dist[curr.y][curr.x];
                        que.addFirst(new Node(nh, nw));
                    }
                } else {
                    if (dist[nh][nw] > dist[curr.y][curr.x] + 1) {
                        dist[nh][nw] = dist[curr.y][curr.x] + 1;
                        que.addLast(new Node(nh, nw));
                    }
                }


            }
        }
    }
}
