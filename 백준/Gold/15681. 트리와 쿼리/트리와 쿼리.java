

import java.io.*;
import java.util.*;

public class Main {
    static int n, r, q;
    static List<List<Integer>> arr = new ArrayList<>();
    static int[] count;
    static boolean[] visited;
//    static List<List<Integer>> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(stk.nextToken());
        r = Integer.parseInt(stk.nextToken());
        q = Integer.parseInt(stk.nextToken());
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        count = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n - 1; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(stk.nextToken());
            int second = Integer.parseInt(stk.nextToken());
            arr.get(first).add(second);
            arr.get(second).add(first);
        }

//        for (int i = 0; i <= n; i++) {
//            tree.add(new ArrayList<>());
//        }

//        for (int i = 1; i <= n; i++) {
//            if (arr.get(r).contains(i)) {
//                makeTree(r, i);
//            }
//        }

        StringBuilder sb = new StringBuilder();
        visited[r] = true;
        countChild(r);
        while (q-- > 0) {
            int query = Integer.parseInt(br.readLine());
            sb.append(count[query]).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

//    private static void makeTree(int parent, int child) {
//        tree.get(parent).add(child);
//        for (int i = 1; i <= n; i++) {
//            if (arr.get(child).contains(i) && i != parent) {
//                makeTree(child, i);
//            }
//        }
//    }

    private static void countChild(int parent) {
        count[parent] = 1;
        for (int child : arr.get(parent)) {
            if (!visited[child]) {
                visited[child] = true;
                countChild(child);
                count[parent] += count[child];
            }
        }
    }
}
