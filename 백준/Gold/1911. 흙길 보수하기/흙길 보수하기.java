
import java.io.*;
import java.util.*;


public class Main {

    static class Water implements Comparable<Water> {
        int start, end;
        public Water(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Water o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        String[] init = br.readLine().split(" ");
        int n = Integer.parseInt(init[0]);
        int L = Integer.parseInt(init[1]);

        PriorityQueue<Water> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            max = Math.max(max, Integer.parseInt(line[1]));
            pq.offer(new Water(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }

        int curr = 0;
        while (!pq.isEmpty()) {
            Water water = pq.poll();

            if (water.start > curr) {
                curr = water.start;
            }

            if (curr >= water.end) continue;

            while (curr < water.end) {
                answer++;
                curr += L;
            }
        }
        System.out.print(answer);
    }
}
