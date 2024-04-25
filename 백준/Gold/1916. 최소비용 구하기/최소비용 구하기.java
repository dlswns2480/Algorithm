

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Node implements Comparable<Node>{
        int vex;
        int cost;

        public Node(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        List<List<Node>> nodes = new ArrayList<>();
        int[] dist = new int[v + 1];
        for(int i = 0; i <=v; i++){
            nodes.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < e; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int price = sc.nextInt();
            nodes.get(from).add(new Node(to, price));
        }
        int start = sc.nextInt();
        int end = sc.nextInt();

        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(start, 0));
        dist[start] = 0;

        while(!que.isEmpty()) {
            Node node = que.poll();
            int nowVertex = node.vex;
            int nowCost = node.cost;
            if(nowCost > dist[nowVertex]) continue;
            for(Node n : nodes.get(nowVertex)) {
                if(nowCost + n.cost < dist[n.vex]){
                    dist[n.vex] = nowCost + n.cost;
                    que.offer(new Node(n.vex, dist[n.vex]));
                }
            }
        }
        System.out.print(dist[end]);



    }


}