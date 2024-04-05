import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int sum = 0;
        int lt = 0;

        int idxSize = Integer.MAX_VALUE;
        for(int rt = 0; rt < sequence.length; rt++){
            sum += sequence[rt];
            
            if(sum == k && rt - lt < idxSize){
                answer = new int[]{lt, rt};
                idxSize = rt- lt;
            }
            while(sum >= k){
                sum -= sequence[lt++];
                if(sum == k && rt - lt < idxSize){
                    answer = new int[]{lt, rt};
                    idxSize = rt- lt;
                }
            }
        }
        return answer;
    }
}