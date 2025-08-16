import java.util.*;
class Solution {
    static List<List<Integer>> matrix = new ArrayList<>();
    static int size;
    static boolean[] visited;
    static Map<Integer, Integer> dist = new HashMap<>();
    static int max = Integer.MIN_VALUE;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        size = n;
        visited = new boolean[n + 1];
        
        for (int i = 0; i <= n; i++) {
            matrix.add(new ArrayList<>());
        }    
        
        for (int[] line : edge) {
            matrix.get(line[0]).add(line[1]);
            matrix.get(line[1]).add(line[0]);
        }
        
        bfs();
        
        for (Map.Entry<Integer, Integer> entry : dist.entrySet()) {
            if (entry.getValue() == max) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        visited[1] = true;
        int L = 0;
        
        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                int poll = que.poll();
                for (int num : matrix.get(poll)) {
                    if (visited[num]) continue;
                    que.offer(num);
                    dist.put(num, L + 1);
                    max = Math.max(max, L + 1);
                    visited[num] = true;
                }
            }
            L++;
        }
    }
}