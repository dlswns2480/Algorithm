

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Long> que = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            que.offer(sc.nextLong());
        }

        long sum = 0;
        while(que.size() > 1) {
            long first = que.poll();
            long sec = que.poll();
            sum += first + sec;
            que.offer(first + sec);
        }
        
        System.out.print(sum);
    }




}