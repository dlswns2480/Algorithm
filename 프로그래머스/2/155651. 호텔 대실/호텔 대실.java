import java.util.*;
class Solution {
    static class Time implements Comparable<Time> {
        int start, end;
        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Time o){
            return this.start - o.start;
        }
    }
    public int solution(String[][] book_time) {
        int answer = 0;
        List<Time> times = new ArrayList<>();
        for(int i = 0; i < book_time.length; i++){
            String[] hours = book_time[i][0].split(":");
            String start = hours[0] + hours[1];
            String[] minutes = book_time[i][1].split(":");
            String end = minutes[0] + minutes[1];
            times.add(new Time(Integer.parseInt(start), Integer.parseInt(end)));
        }
        Collections.sort(times);

        int endTime = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        que.offer(2400);
        for(int i = 0; i < times.size(); i++) {
            endTime = que.peek() + 10;
            if(que.peek() % 100 >= 50){
                endTime = que.peek() + 50;
            }
            // System.out.println(endTime);
            if(times.get(i).start < endTime){
                answer++;
            }        
            else{
                que.poll();
            }
            que.offer(times.get(i).end);
        }
        return answer;
    }
}