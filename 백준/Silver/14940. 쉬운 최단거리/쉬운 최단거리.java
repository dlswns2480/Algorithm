

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int x, y;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][] distance;
    static boolean[][] visited;
    static int cnt = 0;
    static Queue<Curr> que = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        x = Integer.parseInt(s[0]);
        y = Integer.parseInt(s[1]);

        map = new int[x][y];
        visited = new boolean[x][y];
        distance = new int[x][y];

        for(int i = 0; i < x; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < y; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(map[i][j] == 2){
                    bfs(i, j);
                    break;
                }
            }
        }


        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(map[i][j] == 0){
                    distance[i][j] = 0;
                }
                else if(map[i][j] != 0 && !visited[i][j]){
                    distance[i][j] = -1;
                }
                sb.append(distance[i][j]).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb.toString());


    }

    private static void bfs(int gx, int gy) {
        distance[gx][gy] = 0;
        que.offer(new Curr(gx, gy));
        visited[gx][gy] = true;

        while (!que.isEmpty()){
            Curr poll = que.poll();
            for (int i = 0; i < 4; i++){
                int cx = poll.nx + dx[i];
                int cy = poll.ny + dy[i];
                if(cx < 0 || cy < 0 || cx >= x || cy >= y)continue;
                if(map[cx][cy] == 1 & !visited[cx][cy]){
                    distance[cx][cy] = distance[poll.nx][poll.ny] + 1;
                    que.offer(new Curr(cx, cy));
                    visited[cx][cy] = true;
                }

            }
        }


    }

    private static class Curr {
        int nx, ny;
        public Curr(int nx, int ny) {
            this.nx = nx;
            this.ny = ny;
        }
    }


}
