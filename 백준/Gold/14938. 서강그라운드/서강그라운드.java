

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static int n, m, r; //지역 개수, 수색범위, 길의 개수
    static List<List<Node>> nodes = new ArrayList<>();
    static int[] item;
    static class Node implements Comparable<Node> {
        int target, cost;
        Node(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        r = Integer.parseInt(s[2]);
        item = new int[n + 1];
        String[] items = br.readLine().split(" ");
        for(int i = 1; i <= n; i++){
            item[i] = Integer.parseInt(items[i - 1]);
        }
        for(int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }
        for(int i = 0; i < r; i++) {
            String[] routine = br.readLine().split(" ");
            int start = Integer.parseInt(routine[0]);
            int end = Integer.parseInt(routine[1]);
            int cost = Integer.parseInt(routine[2]);
            nodes.get(start).add(new Node(end, cost));
            nodes.get(end).add(new Node(start, cost));
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, bfs(i));
        }
        System.out.print(max);
    }

    private static int bfs(int local) {
        int sum = 0;
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(local, 0));
        int[] dist = new int[n + 1];
        for(int i = 1; i <= n; i++) dist[i] = Integer.MAX_VALUE;
        dist[local] = 0;
        while(!que.isEmpty()) {
            Node curr = que.poll();
            int currNode = curr.target;
            int currCost = curr.cost;
            if(currCost > dist[currNode]) continue;
            for(Node node : nodes.get(currNode)) {
                if(currCost + node.cost < dist[node.target]) {
                    dist[node.target] = currCost + node.cost;
                    que.offer(new Node(node.target, dist[node.target]));
                }
            }
        }

        for(int i = 1; i <= n; i++){
            if(dist[i] <= m) {
                sum += item[i];
            }
        }
        return sum;
    }


}