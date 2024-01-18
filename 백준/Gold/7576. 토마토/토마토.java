

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int x,y;
    static int[][] box;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<Node> que;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        y = Integer.parseInt(s[0]);
        x = Integer.parseInt(s[1]);

        box = new int[x][y];
        que = new LinkedList<>();
        for(int i = 0; i < x; i++){
            String[] s1 = br.readLine().split(" ");
            for(int j = 0; j < y; j++){
                box[i][j] = Integer.parseInt(s1[j]);
            }
        }

        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(box[i][j] == 1){
                    que.offer(new Node(i, j));
                }
            }
        }
        if(que.size() == x * y){
            System.out.print(0);
            return;
        }

        bfs();

        if(checkZero()){
            System.out.print(-1);
            return;
        }

        int maximum = maximum();
        System.out.print(maximum - 1);

    }

    private static void bfs() {
        while(!que.isEmpty()){
            Node node = que.poll();
            for(int i = 0; i < 4; i++){
                int gx = node.nx + dx[i];
                int gy = node.ny + dy[i];
                if(checkRange(gx, gy) && box[gx][gy] == 0){
                    box[gx][gy] = box[node.nx][node.ny] + 1;
                    que.offer(new Node(gx, gy));
                }
            }
        }
    }

    private static int maximum(){
        int max = 0;
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(max < box[i][j]){
                    max = box[i][j];
                }
            }
        }

        return max;
    }

    private static boolean checkZero(){
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(box[i][j] == 0){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean checkRange(int gx, int gy) {
        return gx >= 0 && gy >= 0 && gx < x && gy < y;
    }

    private static class Node {
        int nx, ny;

        public Node(int nx, int ny) {
            this.nx = nx;
            this.ny = ny;
        }
    }
}
