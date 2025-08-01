

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static int n;
    static boolean[] visited;
    static int[] portalInfo;
    static int[] portalKind;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);

        visited = new boolean[n];
        portalInfo = new int[n];
        portalKind = new int[n];
        dist = new int[n];
        for (int i = 0; i < n; i++) {
            portalInfo[i] = i + 1;
            portalKind[i] = 2;

            if(i == n - 1) {
                portalInfo[i] = 0;
            }
        }

        int portalCount = Integer.parseInt(split[1]);
        for (int i = 0; i < portalCount; i++) {
            String[] portal = br.readLine().split(" ");

            int start = Integer.parseInt(portal[1]);
            int end = Integer.parseInt(portal[2]);
            portalInfo[start] = end;
            portalKind[start] = Integer.parseInt(portal[0]);
        }

        Deque<Integer> que = new LinkedList<>();
        que.offer(0);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (!que.isEmpty()) {
            int curr = que.poll();
            int next;
            if (portalKind[curr] == 0) {
                next = portalInfo[curr];
                int cost = dist[curr];
                if (cost < dist[next]) {
                    dist[next] = cost;
                    que.addFirst(next);
                }
            } else if (portalKind[curr] == 1) {
                next = portalInfo[curr];
                int cost = dist[curr];
                if (cost < dist[next]) {
                    dist[next] = cost;
                    que.addFirst(next);
                }
                cost = dist[curr] + 1;
                if (curr + 1 < n && cost < dist[curr + 1]) {
                    dist[curr + 1] = cost;
                    que.addLast(curr + 1);
                }
            } else {
                next = portalInfo[curr];
                int cost = dist[curr] + 1;
                if (cost < dist[next]) {
                    dist[next] = cost;
                    que.addLast(next);
                }
            }
        }


        if (dist[n - 1] == Integer.MAX_VALUE) {
            System.out.print(-1);
            return;
        }
        System.out.print(dist[n - 1]);

    }


}
