

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static String[][] arr;
    static boolean[][] visited;
    static int r;
    static int c;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Node> water = new LinkedList<>();
    static Queue<Node> dochi = new LinkedList<>();
    static String answer = "KAKTUS";
    static class Node{
        int y,x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        r = Integer.parseInt(numbers[0]);
        c = Integer.parseInt(numbers[1]);
        arr = new String[r][c];
        visited = new boolean[r][c];
        int startR = 0;
        int startC = 0;
        for(int i = 0; i < r; i++){
            String[] input = br.readLine().split("");
            for(int j = 0; j < c; j++){
                arr[i][j] = input[j];
                if(arr[i][j].equals("*")){
                    water.offer(new Node(i, j));
                }
                else if(arr[i][j].equals("S")){
                    startR = i;
                    startC = j;
                }
            }
        }
        bfs(startR, startC);
//        for(int i = 0; i < r; i++){
//            for(int j = 0; j < c; j++){
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
        System.out.print(answer);

    }

    private static void bfs(int rr, int cc) {
        int L = 0;
        dochi.offer(new Node(rr, cc));
        visited[rr][cc] = true;
        while(!dochi.isEmpty()) {
            int waterSize = water.size();
            int dochiSize = dochi.size();
            for(int i = 0; i < waterSize; i++){
                Node w = water.poll();
                for(int j = 0; j < 4; j++){
                    int nextR = w.y + dy[j];
                    int nextC = w.x + dx[j];
                    if(nextC < 0 || nextR < 0 || nextR >= r || nextC >= c || visited[nextR][nextC]) continue;
                    if(arr[nextR][nextC].equals(".")){
                        arr[nextR][nextC] = "*";
                        visited[nextR][nextC] = true;
                        water.offer(new Node(nextR, nextC));
                    }
                }
            }

            for(int i = 0; i < dochiSize; i++){
                Node d = dochi.poll();
                for(int j = 0; j < 4; j++){
                    int nextY = d.y + dy[j];
                    int nextX = d.x + dx[j];
                    if(nextX < 0 || nextY < 0 || nextY >= r || nextX >= c || visited[nextY][nextX]) continue;
                    if(arr[nextY][nextX].equals("D")){
                        answer = String.valueOf(L + 1);
                        return;
                    }
                    if(arr[nextY][nextX].equals(".")){
                        arr[nextY][nextX] = "S";
                        visited[nextY][nextX] = true;
                        dochi.offer(new Node(nextY, nextX));
                    }
                }
            }
            L++;
        }
    }
}