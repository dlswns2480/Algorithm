class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] endOfMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dayCount = 0;
        for (int i = 1; i < a; i++) {
            dayCount += endOfMonth[i];
        }
        
        dayCount += b;
        String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        answer = week[(dayCount - 1) % 7];
        
        return answer;
    }
}