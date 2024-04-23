import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 1;
        long lt = 1;
        long rt = (long)Arrays.stream(times).max().getAsInt() * n;
        while(lt <= rt) {
            long mid = (lt + rt) / 2L;
            if(count(mid, times, n) >= n) {
                answer = mid;
                rt = mid - 1;
            }
            else {
                lt = mid + 1;
            }
        }
        return answer;
    }
    
    private static long count(long time, int[] arr, int num){
        long sum = 0;
        for(int x : arr){
            sum += (long)(time / x);
            if(sum > num) return sum;
        }
        return sum;
    }
}