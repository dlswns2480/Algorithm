import java.util.*;
class Solution {
    static int garo, sero;
    static int startX, startY;
    static String[][] arr;
    static boolean[][] visited;
    static int answer = -1;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String[] maps) {
        sero = maps.length;
        garo = maps[0].length();
        arr = new String[sero][garo];
        
        for(int i = 0; i < maps.length; i++){
            arr[i] = maps[i].split("").clone();
        }
        for(int i = 0; i < sero; i++){
            for(int j = 0; j < garo; j++) {
                if(arr[i][j].equals("S")) {
                    startX = j;
                    startY = i;
                }
            }
        }
        
        boolean lever = bfs(startX, startY, "L");
        boolean exit = bfs(startX, startY, "E");
        if(!lever || !exit) return -1;
        if(answer != -1) {
            return ++answer;
        }
        return answer;
    }
    
    private static boolean bfs(int sx, int sy, String target) {
        visited = new boolean[sero][garo];
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(sx, sy));
        visited[sy][sx] = true;
        int L = 1;
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++){
                Point point = que.poll();
                for(int j = 0; j < 4; j++){
                    int nx = point.x + dx[j];
                    int ny = point.y + dy[j];
                    if(nx < 0 || ny < 0 || nx >= garo || ny >= sero || visited[ny][nx]) continue;
                    if(arr[ny][nx].equals("X")) continue;
                    if(arr[ny][nx].equals(target)) {
                        startX = nx;
                        startY = ny;
                        answer += L;
                        return true;
                    }
                    visited[ny][nx] = true;
                    que.offer(new Point(nx, ny));
                }
            }
            L++;
        }
        return false;
    }
}