

import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int n;
    static int targetSero, targetGaro, targetSecond;
    static List<Virus> virusList = new ArrayList<>();
    static class Virus implements Comparable<Virus> {
        int sero, garo, value;
        public Virus(int sero, int garo, int value) {
            this.sero = sero;
            this.garo = garo;
            this.value = value;
        }
        @Override
        public int compareTo(Virus o) {
            return this.value - o.value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().split(" ")[0]);
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] != 0) virusList.add(new Virus(i, j, map[i][j]));
            }
        }
        String[] query = br.readLine().split(" ");

        targetSecond = Integer.parseInt(query[0]);
        targetSero = Integer.parseInt(query[1]);
        targetGaro = Integer.parseInt(query[2]);

        Collections.sort(virusList);
        if (targetSecond == 0) {
            System.out.print(map[targetSero - 1][targetGaro - 1]);
            return;
        }
        bfs();
    }

    private static void bfs() {
        Queue<Virus> queue = new LinkedList<>();
        virusList.forEach(queue::offer);
        int S = 0;
        int restIndex = (n * n) - queue.size();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Virus curr = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int ny = curr.sero + dy[k];
                    int nx = curr.garo + dx[k];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= n || map[ny][nx] != 0) continue;
                    map[ny][nx] = curr.value;
                    restIndex--;
                    queue.offer(new Virus(ny, nx, map[ny][nx]));
                }
            }
            if (++S == targetSecond) {
                System.out.print(map[targetSero - 1][targetGaro - 1]);
                return;
            }
            if (restIndex == 0) {
                System.out.print(map[targetSero - 1][targetGaro - 1]);
                return;
            }
        }
    }
}
