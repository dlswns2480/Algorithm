

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Node implements Comparable<Node>{
        int v1, v2, cost;
        Node(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    static int[] unf;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        unf = new int[v + 1];
        for(int i = 0; i < v; i++) unf[i] = i;
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < e; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            list.add(new Node(v1, v2, cost));
        }
        Collections.sort(list);
        int answer = 0;
        for(Node node : list){
            if(find(node.v1) != find(node.v2)){
                union(node.v1, node.v2);
                answer += node.cost;
            }
        }
        System.out.print(answer);

    }

    private static void union(int first, int second) {
        int fa = find(first);
        int fb = find(second);
        if(fa != fb) {
            unf[fa] = fb;
        }
    }

    private static int find(int number) {
        if(unf[number] == number) return number;
        return unf[number] = find(unf[number]);
    }


}