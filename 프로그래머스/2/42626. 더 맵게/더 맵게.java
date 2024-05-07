import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        int sco = 0;
        for(int n : scoville){
            que.offer(n);
        }
        while(que.peek() < K && que.size() >= 2){
            sco = que.poll() + (que.poll() * 2);
            que.offer(sco);
            // System.out.println(que.peek());
            answer++;
        }
        if(que.peek() < K)
            return -1;
        return answer;
    }
}