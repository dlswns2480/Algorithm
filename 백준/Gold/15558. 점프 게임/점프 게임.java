


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, k, fail;
    static int[] left;
    static int[] right;
    static class Node {
        int idx;
        boolean isLeft;
        int value;
        public Node(int idx, boolean isLeft, int value) {
            this.idx = idx;
            this.isLeft = isLeft;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]); //
        k = Integer.parseInt(split[1]); //
        fail = 0;
        String l = br.readLine();
        String r = br.readLine();
        left = new int[l.length() + 1];
        right = new int[r.length() + 1];
        for(int i = 0; i < l.length(); i++) {
            left[i + 1] = Integer.parseInt(String.valueOf(l.charAt(i)));
        }
        for(int i = 0; i < r.length(); i++) {
            right[i + 1] = Integer.parseInt(String.valueOf(r.charAt(i)));
        }
        int result = bfs();
        if(result == 0) {
            System.out.print(0);
        } else {
            System.out.print(1);
        }


    }

    private static int bfs() {
        Queue<Node> que = new LinkedList<>();
        boolean isLeft = true;
        que.offer(new Node(1, true, left[1]));
        boolean visited[][] = new boolean[2][n + 1];
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                Node curr = que.poll();
                if(curr.idx <= fail) continue;
                if(curr.idx > n || curr.idx + k > n || curr.idx + 1 > n) {
                    return curr.value;
                }
//                System.out.println(curr.idx);
                if(curr.isLeft) {
                    if(curr.idx - 1 > 0 && left[curr.idx - 1] != 0 && !visited[0][curr.idx - 1]) {
                        que.offer(new Node(curr.idx - 1, true, left[curr.idx - 1]));
                        visited[0][curr.idx - 1] = true;
                    }
                    if(curr.idx + 1 <= n && left[curr.idx + 1] != 0 && !visited[0][curr.idx + 1]) {
                        que.offer(new Node(curr.idx + 1, true, left[curr.idx + 1]));
                        visited[0][curr.idx + 1] = true;
                    }
                    if(curr.idx + k <= n && right[curr.idx + k] != 0 && !visited[1][curr.idx + k]) {
                        que.offer(new Node(curr.idx + k, false, right[curr.idx + k]));
                        visited[1][curr.idx + k] = true;
                    }
                }
                else {
                    if(curr.idx - 1 > 0 && right[curr.idx - 1] != 0 && !visited[1][curr.idx - 1]) {
                        que.offer(new Node(curr.idx - 1, false, right[curr.idx - 1]));
                        visited[1][curr.idx - 1] = true;
                    }
                    if(right[curr.idx + 1] != 0 && !visited[1][curr.idx + 1]) {
                        que.offer(new Node(curr.idx + 1, false, right[curr.idx + 1]));
                        visited[1][curr.idx + 1] = true;
                    }
                    if(left[curr.idx + k] != 0 && !visited[0][curr.idx + k]) {
                        que.offer(new Node(curr.idx + k, true, left[curr.idx + k]));
                        visited[0][curr.idx + k] = true;
                    }
                }
            }
            fail++;
        }
        return 0;
    }


}
