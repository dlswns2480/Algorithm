

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        List<Integer> lst = new ArrayList<>();
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            int input = Integer.parseInt(br.readLine());
            if (que.isEmpty() && input == 0) {
                lst.add(0);
            } else if (!que.isEmpty() && input == 0) {
                lst.add(que.poll());
            } else {
                que.offer(input);
            }
        }
        for (int i = 0; i < lst.size() - 1; i++) {
            System.out.println(lst.get(i));
        }

        System.out.print(lst.get(lst.size() - 1));
    }

}
