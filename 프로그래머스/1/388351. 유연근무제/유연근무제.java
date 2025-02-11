import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i = 0; i < schedules.length; i++) {
            int namu = schedules[i] % 100;
            if(namu + 10 >= 60) {
                schedules[i] += 40;
            }
            schedules[i] += 10;
        }
        for(int i = 0; i < timelogs.length; i++) {
            boolean flag = true;
            int start = startday;
            for(int j = 0; j < timelogs[i].length; j++) {
                if(start == 8) start = 1;
                if(start < 6 && timelogs[i][j] > schedules[i]) {
                    flag = false;
                    break;
                }
                start++;
            }
            if(flag) answer++;
        }
        return answer;
    }
}