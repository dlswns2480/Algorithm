import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static int m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        int firstCount = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 1) {
                    firstCount++;
                }
            }
        }
        int currCount = firstCount;
        int hour = 0;
        List<Integer> answers = new ArrayList<>();
        while (getCount() > 0){
            hour++;
            bfs(0, 0);
            answers.add(getCount());
        }
        System.out.println(hour);
        if(answers.size() < 3){
            System.out.print(firstCount);
            return;
        }
        System.out.print(answers.get(answers.size() - 2));
    }

    private static void bfs (int sero, int garo) {
        visited = new boolean[n][m];
        Queue<Node> que = new LinkedList<>();
        visited[sero][garo] = true;
        que.offer(new Node(sero, garo));
        while(!que.isEmpty()) {
            Node node = que.poll();
            int size = que.size();
            for(int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx]) continue;
                if(arr[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    que.offer(new Node(ny, nx));
                }
                else if (arr[ny][nx] == 1) {
                    arr[ny][nx] -= 1;
                    visited[ny][nx] = true;
                }
            }
        }
    }

    private static int getCount() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static class Node {
        int y, x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

}