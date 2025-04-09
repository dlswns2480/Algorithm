import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Map<Integer, Integer> willOff = new HashMap<>();
        int currServer = 0;
        for(int i = 0; i < players.length; i++) {
            currServer = currServer - willOff.getOrDefault(i, 0);
            
            
            if(players[i] >= m) {
                int n = players[i] / m;    
                if(currServer < n) {
                    int willAddServer = n - currServer;
                    willOff.put(i + k, willAddServer);
                    currServer += willAddServer;
                    answer += willAddServer;
                }
            }
        }
        
        return answer;
    }
}