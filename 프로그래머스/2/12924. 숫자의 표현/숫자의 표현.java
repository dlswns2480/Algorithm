class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int lt = 1, rt = 1, sum = 1;
        
        while (rt <= n) {
            if (sum == n) answer++;
            
            if (sum >= n) sum -= lt++;
            
            else if (sum < n) sum += ++rt;
        }
        
        return answer;
    }
}