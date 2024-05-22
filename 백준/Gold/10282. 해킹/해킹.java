

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static List<List<Node>> nodes;
    static boolean[] visited;
    static int[] dist;
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
        int testCase = Integer.parseInt(br.readLine());
        int count;
        int time;
        for(int i = 0; i < testCase; i++){
            count = 0;
            time = 0;
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int d = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            nodes = new ArrayList<>();
            visited = new boolean[n + 1];
            dist = new int[n + 1];
            for(int j = 0; j <= n; j++) {
                nodes.add(new ArrayList<>());
                dist[j] = Integer.MAX_VALUE;
            }

            for(int j = 0; j < d; j++){
                String[] input2 = br.readLine().split(" ");
                int a = Integer.parseInt(input2[0]);
                int b = Integer.parseInt(input2[1]);
                int s = Integer.parseInt(input2[2]);
                nodes.get(b).add(new Node(a, s));
            }
            bfs(c);
            for(int j = 1; j <= n; j++) {
//                System.out.println("j : " + j + ", dist[j] : " + dist[j]);
                if(dist[j] != Integer.MAX_VALUE) {
                    count++;
                    time = Math.max(time, dist[j]);
                }
            }
            System.out.println(count + " " + time);

        }

    }

    private static void bfs(int start) {
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(start, 0));
        visited[start] = true;
        dist[start] = 0;
        while(!que.isEmpty()) {
            Node curr = que.poll();
            int currNode = curr.target;
            int currCost = curr.cost;
            if(currCost > dist[currNode]) continue;
            for(Node node : nodes.get(currNode)) {
                if(visited[node.target]) continue;

                if(currCost + node.cost < dist[node.target]) {
                    dist[node.target] = currCost + node.cost;
                    que.offer(new Node(node.target, dist[node.target]));
                }
            }
        }
    }


}