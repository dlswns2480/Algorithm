

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static int n;
    static int m;
    static int[] dist;
    static List<List<Node>> nodes = new ArrayList<>();
    static class Node implements Comparable<Node> {
        int target, cost;
        Node(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o. cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        dist = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
            nodes.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            String[] s = br.readLine().split(" ");
            Node node1 = new Node(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            Node node2 = new Node(Integer.parseInt(s[0]), Integer.parseInt(s[2]));
            nodes.get(Integer.parseInt(s[0])).add(node1);
            nodes.get(Integer.parseInt(s[1])).add(node2);
        }

        bfs();


        System.out.print(dist[n]);
    }

    private static void bfs() {
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(1, 0));
        dist[1] = 0;
        while(!que.isEmpty()){
            Node node = que.poll();
            int currNode = node.target;
            int currCost = node.cost;
            if(dist[currNode] < currCost) continue;
            for(Node n : nodes.get(currNode)) {
                if(dist[n.target] > currCost + n.cost){
                    dist[n.target] = currCost + n.cost;
                    que.offer(new Node(n.target, dist[n.target]));
                }
            }
        }
    }


}