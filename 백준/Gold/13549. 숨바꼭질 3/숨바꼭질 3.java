


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class Main {
    static int subin, sister;
    static boolean[] visited;
    static class Node {
        int pos;
        int time;

        Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        subin = Integer.parseInt(split[0]);
        sister = Integer.parseInt(split[1]);
        visited = new boolean[100001];
        if(subin == sister) {
            System.out.print(0);
            return;
        }
        int answer = bfs();
        System.out.print(answer);

    }

    private static int bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(subin, 0));
        int result = Integer.MAX_VALUE;
        visited[subin] = true;
        loop:
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                Node poll = que.poll();
                int currTime = poll.time;
                int[] arr = new int[3];
                arr[0] = poll.pos * 2;
                arr[1] = poll.pos - 1;
                arr[2] = poll.pos + 1;

                for(int j = 0; j < 3; j++) {
                    if(arr[j] == sister && j == 0) {
                        result = Math.min(result, currTime);
                    } else if(arr[j] == sister && j != 0) {
                        result = Math.min(result, currTime + 1);
                    }
                    if(arr[j] < 0 || arr[j] > 100000) continue;
                    if(visited[arr[j]]) continue;
                    if(j == 0) {
                        visited[arr[j]] = true;
                        que.add(new Node(arr[j], currTime));
                        continue;
                    }
                    visited[arr[j]] = true;
                    que.add(new Node(arr[j], currTime + 1));
                }
            }
//            if(result != Integer.MAX_VALUE) {
//                break loop;
//            }
        }
        return result;
    }


}
