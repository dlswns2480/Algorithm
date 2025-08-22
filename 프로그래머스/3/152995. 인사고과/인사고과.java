import java.util.*;
class Solution {
    static class Info implements Comparable<Info> {
        int attitude, eval;
        Info(int attitude, int eval) {
            this.attitude = attitude;
            this.eval = eval;
        }
        
        public int getSum() {
            return this.attitude + this.eval;
        }
        
        @Override
        public int compareTo(Info o) {
            if (this.attitude == o.attitude) return this.eval - o.eval;
            return o.attitude - this.attitude;
        }
    }
    public int solution(int[][] scores) {
        int answer = 0;
        
        int wanAttitude = scores[0][0];
        int wanEval = scores[0][1];
        
        List<Info> infos = new ArrayList<>();
        
        for (int i = 0; i < scores.length; i++) {
            infos.add(new Info(scores[i][0], scores[i][1]));
        }
        
        Collections.sort(infos);
        List<Info> valid = new ArrayList<>();
        
        int maxEval = Integer.MIN_VALUE;
        
        for (int i = 0; i < infos.size(); i++) {
            Info curr = infos.get(i);
            if (curr.eval < maxEval) {
                if(curr.attitude == wanAttitude && curr.eval == wanEval) return -1;
            } else {
                valid.add(curr);
                maxEval = Math.max(maxEval, curr.eval);
            }
        }
        
        int peopleCount = 0;
        for (int i = 0; i < valid.size(); i++) {
            Info info = valid.get(i);
            if (info.attitude < wanAttitude && info.eval < wanEval) continue;
            
            int otherSum = info.getSum();
            int wanSum = wanAttitude + wanEval;
            
            if (otherSum > wanSum) peopleCount++;
        }
        
        return peopleCount + 1;
    }
}