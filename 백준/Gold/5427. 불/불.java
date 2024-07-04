

import java.io.*;
import java.util.*;

public class Main {
    static int garo, sero;
    static String[][] arr;
    static boolean[][] visited;
    static boolean[][] sangVisited;
    static Queue<Node> fire = new LinkedList<>();
    static Queue<Node> sang = new LinkedList<>();
    static boolean flag;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer;
    static class Node {
        int y, x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for(int k = 0; k < testCase; k++) {

            fire.clear();
            sang.clear();
            answer = -1;
            String[] info = br.readLine().split(" ");
            garo = Integer.parseInt(info[0]);
            sero = Integer.parseInt(info[1]);
            arr = new String[sero][garo];
            visited = new boolean[sero][garo];
            sangVisited = new boolean[sero][garo];
            for(int i = 0; i < sero; i++) {
                String[] s = br.readLine().split("");
                for(int j = 0; j < garo; j++) {
                    arr[i][j] = s[j];
                    if(arr[i][j].equals("@")) sang.offer(new Node(i, j));
                    if(arr[i][j].equals("*")) {
                        fire.offer(new Node(i, j));
                        visited[i][j] = true;
                    }
                }
            }
            bfs();
            if(answer == -1) {
                sb.append("IMPOSSIBLE").append("\n");
                continue;
            }

            sb.append(answer).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));

    }

    private static void bfs() {
        int L = 0;
        while (!sang.isEmpty()) {
            int fireSize = fire.size();
            for(int i = 0; i < fireSize; i++) {
                Node fnode = fire.poll();
                for(int j = 0; j < 4; j++) {
                    int nx = fnode.x + dx[j];
                    int ny = fnode.y + dy[j];
                    if(nx < 0 || ny < 0 || nx >= garo || ny >= sero) continue;
                    if(arr[ny][nx].equals(".") || arr[ny][nx].equals("@")) {
                        fire.offer(new Node(ny, nx));
                        arr[ny][nx] = "*";
                    }
                }
            }
            int sangSize = sang.size();
            for(int i = 0; i < sangSize; i++) {
                Node snode = sang.poll();
                for(int j = 0; j < 4; j++) {
                    int nx = snode.x + dx[j];
                    int ny = snode.y + dy[j];
                    if(nx < 0 || ny < 0 || nx >= garo || ny >= sero) {
                        answer = L + 1;
                        return;
                    }
                    if(visited[ny][nx]) continue;
                    if(arr[ny][nx].equals(".")) {
                        sang.offer(new Node(ny, nx));
                        visited[ny][nx] = true;
                    }
                }
            }
            L++;
        }
    }

}

