import java.util.*;
class Solution {
    static List<List<Integer>> edge = new ArrayList<>();
    static int goal;
    static int size;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        size = n;
        goal = destination;
        for (int i = 0; i <= n; i++) {
            edge.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            edge.get(road[0]).add(road[1]);
            edge.get(road[1]).add(road[0]);
        }
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = bfs(sources[i]);
        }
        return answer;
    }
    
    private static int bfs(int loc) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(loc);
        boolean[] visited = new boolean[size + 1];
        visited[loc] = true;
        int L = 0;
        if (loc == goal) return 0;
        
        while (!que.isEmpty()) {
            int queSize = que.size();
            for (int i = 0; i < queSize; i++) {
                int poll = que.poll();
                for (int next : edge.get(poll)) {
                    if (visited[next]) continue;
                    if (next == goal) return L + 1;
                    visited[next] = true;
                    que.offer(next);
                }
            }
            L++;
        }
        return -1;
    }
}