

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Point implements Comparable<Point>{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(this.y == o.y) return this.x - o.x;
            return o.y - this.y;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxDay = Integer.MIN_VALUE;
        List<Point> lst = new ArrayList<>();
        for(int i = 0; i< n; i++){
            int money = sc.nextInt();
            int day = sc.nextInt();
            lst.add(new Point(money, day));
            if(maxDay < day) {
                maxDay = day;
            }
        }
        Collections.sort(lst);

        Queue<Integer> moneyQ = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        int j =0;
        for(int i = maxDay; i > 0; i--){
            for(; j < n; j++){
                if(lst.get(j).y < i) break;
                moneyQ.offer(lst.get(j).x);
            }
            if(!moneyQ.isEmpty()) {
                int plusMoney = moneyQ.poll();
                answer += plusMoney;
            }
        }
        System.out.print(answer);
    }


}