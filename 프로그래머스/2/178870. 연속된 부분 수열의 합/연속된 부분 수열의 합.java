import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int sum = 0;
        int lt = 0;
        List<int[]> lst = new ArrayList<>();
        
        for(int rt = 0; rt < sequence.length; rt++){
            sum += sequence[rt];
            if(sum == k){
                lst.add(new int[]{lt, rt});
            }
            while(sum >= k){
                sum -= sequence[lt++];
                if(sum == k) {
                    lst.add(new int[]{lt, rt});
                }
            }
        }
        int idxSize = Integer.MAX_VALUE;
        for(int i = 0; i < lst.size(); i++){
            int[] arr = lst.get(i);
            int size = arr[1] - arr[0];
            if(size < idxSize) {
                idxSize = size;
                answer = arr;
            }
        }
        return answer;
    }
}