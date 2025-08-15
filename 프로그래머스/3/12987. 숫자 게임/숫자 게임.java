import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int len = B.length;
        
        Integer[] arrA = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Integer[] arrB = Arrays.stream(B).boxed().toArray(Integer[]::new);
        
        Arrays.sort(arrA, Collections.reverseOrder());
        Arrays.sort(arrB, Collections.reverseOrder());
        
        int j = 0;
        
        for (int i = 0; i < len && j < len; i++) {
            if (arrB[j] > arrA[i]) {
                answer++;
                j++;
            }
        }
        
        return answer;
        
    }
}