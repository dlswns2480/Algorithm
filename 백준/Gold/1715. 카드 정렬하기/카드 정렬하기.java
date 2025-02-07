

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> que = new PriorityQueue<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            que.add(sc.nextInt());
        }
        int sum = 0;
        while(que.size() > 1) {
            int first = que.poll();
            int second = que.poll();
            sum += (first + second);
            que.offer(first+second);
        }
        System.out.print(sum);


    }


}

