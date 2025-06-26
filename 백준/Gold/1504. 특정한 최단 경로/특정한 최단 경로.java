


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static int n, e, v1, v2;
    static boolean[] visited;
    static int[] dist;
    static List<List<Edge>> graph;

    static class Edge implements Comparable<Edge> {
        int vex, cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ne = br.readLine().split(" ");
        n = Integer.parseInt(ne[0]);
        e = Integer.parseInt(ne[1]);
        visited = new boolean[n + 1];

        graph = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            graph.get(start).add(new Edge(end, cost));
            graph.get(end).add(new Edge(start, cost));
        }
        String[] shouldPass = br.readLine().split(" ");
        v1 = Integer.parseInt(shouldPass[0]);
        v2 = Integer.parseInt(shouldPass[1]);

        final int INF = 200_000_000;

        int d1 = djikstra(1, v1);
        int d2 = djikstra(v1, v2);
        int d3 = djikstra(v2, n);

        int d4 = djikstra(1, v2);
        int d5 = djikstra(v2, v1);
        int d6 = djikstra(v1, n);

        int result1 = (d1 >= INF || d2 >= INF || d3 >= INF) ? INF : d1 + d2 + d3;
        int result2 = (d4 >= INF || d5 >= INF || d6 >= INF) ? INF : d4 + d5 + d6;

        int answer = Math.min(result1, result2);
        if (answer >= INF) answer = -1;

        System.out.print(answer);
    }

    private static int djikstra(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            dist[i] = 200_000_000;
        }
        dist[start] = 0;
        while(!pq.isEmpty()) {
            Edge currEdge = pq.poll();
            int currVex = currEdge.vex;
            int currCost = currEdge.cost;

            if(currCost > dist[currVex]) continue;

            for(Edge edge : graph.get(currVex)) {
                int nextVex = edge.vex;
                int nextCost = edge.cost + currCost;
                if(nextCost < dist[nextVex]) {
                    dist[nextVex] = nextCost;
                    pq.offer(new Edge(nextVex, nextCost));
                }
            }
        }
        return dist[end];
    }
}
