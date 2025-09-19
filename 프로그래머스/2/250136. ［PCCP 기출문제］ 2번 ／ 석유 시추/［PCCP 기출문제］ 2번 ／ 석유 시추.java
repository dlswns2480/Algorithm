import java.util.*;
class Solution {
    static int[] oils;
    static int garo, sero;
    static boolean[][] visited;
    static boolean[][] extractVisited;
    static Map<String, Integer> width = new HashMap<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int solution(int[][] land) {
        int answer = 0;

        garo = land[0].length;
        sero = land.length;

        oils = new int[garo];
        visited = new boolean[sero][garo];


        for (int i = 0; i < sero; i++) {
            for (int j = 0; j < garo; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, land);
                }
            }
        }
        
        Arrays.sort(oils);

        return oils[oils.length - 1];
    }

    private static int bfs(int se, int ga, int[][] land) {
        Set<Integer> set = new HashSet<>();
        int cnt = 1;


        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(se, ga));
        set.add(ga);

        visited[se][ga] = true;

        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                Point point = que.poll();
                for(int j = 0; j < 4; j++) {
                    int ns = point.s + dy[j];
                    int ng = point.g + dx[j];
                    if(ns < 0 || ng < 0 || ns >= sero || ng >= garo || visited[ns][ng]) continue;
                    if(land[ns][ng] == 1) {
                        cnt++;
                        visited[ns][ng] = true;
                        que.offer(new Point(ns, ng));
                        set.add(ng);
                    }
                }
            }
        }
        for (Integer value : set) {
            oils[value] += cnt;
        }


        return cnt;
    }

    static class Point {
        int s, g;
        Point(int s, int g) {
            this.s = s;
            this.g = g;
        }
    }
}