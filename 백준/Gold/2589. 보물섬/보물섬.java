

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int sero, garo;
    static String[][] map;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Point {
        int y, x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        sero = Integer.parseInt(input[0]);
        garo = Integer.parseInt(input[1]);
        map = new String[sero][garo];
        for(int i = 0; i < sero; i++) {
            String[] point = br.readLine().split("");
            for(int j = 0; j < garo; j++) {
                map[i][j] = point[j];
            }
        }

        for(int i = 0; i < sero; i++) {
            for(int j = 0; j < garo; j++) {
                if(map[i][j].equals("L")) {
                    bfs(i, j);
                }
            }
        }

        System.out.print(max - 1);
    }

    private static void bfs(int y, int x) {
        visited = new boolean[sero][garo];
        int L = 0;
        Queue<Point> points = new LinkedList<>();
        points.add(new Point(y, x));
        visited[y][x] = true;
        while (!points.isEmpty()) {
            int size = points.size();
            for(int i = 0; i < size; i++) {
                Point point = points.poll();
                for(int j = 0; j < 4; j++) {
                    int ny = point.y + dy[j];
                    int nx = point.x + dx[j];
                    if(ny < 0 || nx < 0 || ny >= sero || nx >= garo || visited[ny][nx]) continue;
                    if(map[ny][nx].equals("L")) {
                        points.add(new Point(ny, nx));
                        visited[ny][nx] = true;
                    }
                }
            }
            L++;
        }

        max = Math.max(max, L);
    }

}

