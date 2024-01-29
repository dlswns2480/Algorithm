

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int add = Integer.parseInt(s[1]);

        PriorityQueue<Long> que = new PriorityQueue<>();
        String[] card = br.readLine().split(" ");
        for(String str : card){
            que.offer(Long.parseLong(str));
        }

        for(int i = 0; i < add; i++){
            long first = que.poll();
            long sec = que.poll();
            que.offer(first + sec);
            que.offer(first + sec);
        }
        long sum = 0;
        for(long integer : que){
            sum += integer;
        }
        System.out.print(sum);

    }

}
