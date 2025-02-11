import java.util.*;
class Solution {
    static int[] diff;
    static int[] time;
    static long limits;
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        diff = diffs.clone();
        time = times.clone();
        limits = limit;
        
        int min = 1;
        int max = Arrays.stream(diff).max().getAsInt();
        
        
        while(min < max) {
            int mid = (min + max) / 2;
            boolean isResolved = isResolve(mid, diff.length);
            if(isResolved) {
                max = mid;
            } else {
                min = mid + 1;
            }
            
            
        }
        
        
        return min;
    }
    private static boolean isResolve(int level, int len) {
        long sum = 0;
        sum += time[0];
        for(int i = 1; i < len; i++) {
            if(diff[i] > level) {
                sum += ((diff[i] - level) * (time[i-1] + time[i]) + time[i]);
            } else if(diff[i] <= level) {
                sum += time[i];
            }
        }
        return sum <= limits;
    }
}