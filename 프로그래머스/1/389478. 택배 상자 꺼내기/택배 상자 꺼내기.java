class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int divide = n / w;
        int[][] arr = new int[divide + 2][w + 1];
        int value = 1;
        int garo = 0;
        int sero = 0;
        for(int i = 1; i < arr.length; i++) {
            for(int j = 1; j <= w && value <= n; j++) {
                arr[i][j] = value;
                if(value == num) {
                    garo = j;
                    sero = i;
                }
                value++;
            }
        }
        
        
        
        for(int i = sero + 1; i < arr.length; i++) {
            garo = w - garo + 1;    

            if(arr[i][garo] != 0) {
                answer++;
            }    
        }
                                                
        answer++;
        return answer;
    }
}