

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Node {
        int y, x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int sero, garo;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int wallCnt = 0;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        sero = sc.nextInt();
        garo = sc.nextInt();
        arr = new int[sero][garo];
        for(int i = 0; i < sero; i++) {
            for(int j = 0; j < garo; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        dfs(0);

        System.out.print(max);
    }

    private static void dfs(int wall) {
        if(wall == 3) {
            bfs();
            return;
        }
        for(int i = 0; i < sero; i++) {
            for(int j = 0; j < garo; j++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(wall + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        int width = 0;
        Queue<Node> que = new LinkedList<>();
        visited = new boolean[sero][garo];
        for(int i = 0; i < sero; i++) {
            for(int j = 0; j < garo; j++) {
                if(arr[i][j] == 2) {
                    que.offer(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }
        while(!que.isEmpty()) {
            Node node = que.poll();
            for(int j = 0; j < 4; j++) {
                int nx = node.x + dx[j];
                int ny = node.y + dy[j];
                if(nx < 0 || nx >= garo || ny < 0 || ny >= sero || visited[ny][nx]) continue;
                if(arr[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    que.offer(new Node(ny, nx));
                }
            }
        }
        width = getSafe();
        max = Math.max(max, width);
    }

    private static int getSafe() {
        int safe = 0;
        for(int i = 0; i < sero; i++) {
            for(int j = 0; j < garo; j++) {
                if(arr[i][j] == 0 && !visited[i][j]) {
                    safe++;
                }
            }
        }
        return safe;
    }

}

