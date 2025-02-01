import java.util.*;
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        Arrays.sort(wallet);
        Arrays.sort(bill);
        boolean flag = false;
        if((bill[0] <= wallet[0] && bill[1] <= wallet[1]) || (bill[0] <= wallet[1] && bill[1] <= wallet[0]))  return answer;
        
        while(!flag) {
            if((bill[0] <= wallet[0] && bill[1] <= wallet[1]) || (bill[0] <= wallet[1] && bill[1] <= wallet[0])) {
                return answer;
            }
            Arrays.sort(bill);
            
            bill[1] /= 2;
            answer++;
            
        }
        
        return answer;
    }
}