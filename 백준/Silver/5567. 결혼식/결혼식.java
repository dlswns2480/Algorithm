
import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> relations = new ArrayList<>();
    static int n;
    static int relationSize;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        relationSize = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            relations.add(new ArrayList<>());
        }
        for (int i = 0; i < relationSize; i++) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            relations.get(a).add(b);
            relations.get(b).add(a);
        }

        bfs();
        System.out.print(answer);
    }

    private static void bfs() {
        int L = 0;
        Queue<Integer> que = new LinkedList<>();
        visited = new boolean[n + 1];
        que.add(1);
        visited[1] = true;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int current = que.poll();
                for (int next : relations.get(current)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        que.offer(next);
                        answer++;
                    }
                }
            }
            L++;
            if(L == 2) {
                return;
            }
        }
    }
}
