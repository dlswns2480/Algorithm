


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static class Pair implements Comparable<Pair> {
        int idx, value;
        Pair(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            if(o.value == this.value) {
                return o.idx - this.idx;
            }
            return o.value - this.value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dasom = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            pq.offer(new Pair(i + 1, m));
            if(i == 0) {
                dasom = m;
            }
        }

        int count = 0;

        while(true) {
            Pair first = pq.poll();
            if (first.idx == 1) break;

            dasom += 1;
            pq.offer(new Pair(first.idx, first.value - 1));
            pq.offer(new Pair(1, dasom));
            count++;
        }

        System.out.print(count);

    }


}
