

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n; // student
    static int m; //relationship
    static int k; //money
    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        int[] cost = new int[n + 1];
        int[] minCost = new int[n + 1];


        boolean[] visited = new boolean[n + 1];

        arr = new int[n + 1];
        for(int i = 0; i <= n; i++) arr[i] = i;

        for(int i = 1; i <= n; i++){
            cost[i] = sc.nextInt();
        }
        for(int i = 0; i <= n; i++) minCost[i] = cost[i];
        for(int i = 0; i < m; i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            union(n1, n2);
        }
        int needCost = 0;

        for(int i = 1; i <= n; i++){
            int find = find(i);
            if(visited[find]) continue;
            visited[find] = true;
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= n; j++){
                if(find(j) == find){
                    min = Math.min(min, cost[j]);
                }
            }

            needCost += min;
            if(needCost > k){
                System.out.print("Oh no");
                return;
            }
        }
        System.out.print(needCost);
    }

    private static int find(int num){
        if(arr[num] == num) return num;
        return arr[num] = find(arr[num]);
    }
    private static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) arr[fa] = fb;
    }
}