import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        int end = targets[0][1];
        for(int i = 1; i < targets.length; i++) {
            if(targets[i][0] >= end) {
                answer++;
                end = targets[i][1];
            }
        }
        
        return answer;
    }
}