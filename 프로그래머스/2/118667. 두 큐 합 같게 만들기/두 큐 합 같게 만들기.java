import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int[] arr = new int[queue1.length + queue2.length];
        long sum = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        long target = (sum + sum2) / 2;
        if ((sum + sum2) % 2 != 0) return -1;
        
        
        int i = 0;
        for (; i < queue1.length; i++) {
            arr[i] = queue1[i];    
        }
        
        for (int j = 0; j < queue2.length; j++) {
            arr[i] = queue2[j];
            i++;
        }
        
        int lt = 0;
        int rt = queue1.length;
        
        while (rt < arr.length) {
            if (sum == target) break;
            if (sum > target) {
                sum -= arr[lt++];
            } else if (sum < target) {
                sum += arr[rt++];
            }
            answer++;
        }
        
        if (sum != target) return -1;
        
        return answer;
    }
}