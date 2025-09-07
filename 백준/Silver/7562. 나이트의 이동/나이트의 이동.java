

import java.io.*;
import java.util.*;


public class Main {

    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    static class Node {
        int y, x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] s = br.readLine().split(" ");
            String[] e = br.readLine().split(" ");
            int sy = Integer.parseInt(s[0]);
            int sx = Integer.parseInt(s[1]);
            int ey = Integer.parseInt(e[0]);
            int ex = Integer.parseInt(e[1]);

            int result = bfs(arr, sy, sx, ey, ex);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static int bfs(int[] arr, int sy, int sx, int ey, int ex) {
        int L = 0;
        Queue<Node> que = new LinkedList<>();
        boolean[][] visited = new boolean[arr.length][arr.length];
        que.offer(new Node(sy, sx));
        visited[sy][sx] = true;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Node cur = que.poll();
                for (int j = 0; j < 8; j++) {
                    int ny = cur.y + dy[j];
                    int nx = cur.x + dx[j];
                    if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length || visited[ny][nx]) continue;
                    if (ny == ey && nx == ex) return L + 1;
                    que.offer(new Node(ny, nx));
                    visited[ny][nx] = true;
                }
            }
            L++;
        }
        return 0;
    }
}
