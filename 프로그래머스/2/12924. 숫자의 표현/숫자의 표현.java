class Solution {
    public int solution(int n) {
        int answer = 0;
        if (n == 1) return 1;
        int[] arr = new int[n + 3];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        
        int lt = 1;
        int rt = 2;
        
        int sum = arr[lt] + arr[rt];
        
        while (rt <= n) {
            if (sum >= n) {
                if (sum == n) {
                    answer++;
                }
                sum -= arr[lt];
                lt++;
            } else if (sum < n) {
                if (rt == n) break;
                rt++;
                sum += arr[rt];
            }
        }
        
        return answer;
    }
}