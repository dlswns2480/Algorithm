

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int answer = Integer.MIN_VALUE;
    static List<List<Node>> nodes = new ArrayList<>();
    static boolean[] visited;
    static class Node{
        int target, cost;
        Node(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i <= n; i++){
            nodes.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++){
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int money = Integer.parseInt(input[2]);
            nodes.get(start).add(new Node(end, money));
            nodes.get(end).add(new Node(start, money));
        }

        for(int i = 1; i <= n; i++){
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, 0);
        }

        System.out.print(answer);
    }

    private static void dfs(int num, int sum) {
        answer = Math.max(answer, sum);
        for(Node node : nodes.get(num)) {
            int target = node.target;
            int cost = node.cost;
            if(!visited[target]){
                visited[target] = true;
                dfs(target, sum + cost);
            }
        }
    }

}