


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static class Lesson implements Comparable<Lesson> {
        int start, end;
        public Lesson(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Lesson o) {
            if (this.start == o.start) return this.end - o.end;
            return this.start - o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        List<Lesson> lessons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            lessons.add(new Lesson(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }
        Collections.sort(lessons);
        pq.offer(lessons.get(0).end);
        for (int i = 1; i < n; i++) {
            Lesson lesson = lessons.get(i);
            if (lesson.start >= pq.peek()) {
                pq.poll();
            }
            pq.offer(lesson.end);
        }

        System.out.print(pq.size());
    }

}
