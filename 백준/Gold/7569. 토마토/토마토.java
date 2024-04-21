

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n; //세로
    static int m; //가로
    static int h;// 높이
    static int[][][] arr; // 상자
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<Point> que = new LinkedList<>();
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt(); // 가로
        n = sc.nextInt(); // 세로
        h = sc.nextInt();
        arr = new int[h][n][m];
        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    arr[i][j][k] = sc.nextInt();
                    if(arr[i][j][k] == 1) que.offer(new Point(i, j, k));
                }
            }
        }
        int result = bfs();

        System.out.print(result);

    }

    private static int bfs() {

        while(!que.isEmpty()){
            Point point = que.poll();
            for(int j = 0; j < 6; j++){
                int currX = point.x + dx[j];
                int currY = point.y + dy[j];
                int currZ = point.z + dz[j];

                if(currX >= m || currX < 0 || currY >= n || currY < 0 || currZ >= h || currZ < 0) continue;

                if(arr[currZ][currY][currX] == 0){
                    arr[currZ][currY][currX] = arr[point.z][point.y][point.x] + 1;
                    que.offer(new Point(currZ, currY, currX));
                }
            }
        }

        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    if(arr[i][j][k] == 0) {
                        return -1;
                    }
                    answer = Math.max(answer, arr[i][j][k]);
                }
            }
        }
        return answer - 1;

    }

    static class Point{
        int z, y, x;
        Point(int z, int y, int x){
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }


}