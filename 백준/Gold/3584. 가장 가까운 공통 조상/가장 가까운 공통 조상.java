

import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> lst = new ArrayList<>();
    static Map<Integer, Integer> map;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            answer = 0;
            map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            visited = new boolean[n + 1];
            for(int j = 0; j < n - 1; j++) {
                String[] s = br.readLine().split(" ");
                int parent = Integer.parseInt(s[0]);
                int child = Integer.parseInt(s[1]);
                map.put(child, parent);
            }
            String[] nodes = br.readLine().split(" ");
            int first = Integer.parseInt(nodes[0]);
            int sec = Integer.parseInt(nodes[1]);
            visited[first] = true;
            fdfs(first);
            sdfs(sec);
            sb.append(answer).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static void sdfs(int node) {
        if(visited[node]) {
            answer = node;
            return;
        }
        int next = map.getOrDefault(node, -1);
        if(next == -1) {
            return;
        }
        sdfs(next);
    }

    private static void fdfs(int node) {
        int next = map.getOrDefault(node, -1);
        if(next == -1) {
            return;
        }
        visited[next] = true;
        fdfs(next);
    }

}

