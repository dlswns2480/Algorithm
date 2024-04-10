import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        boolean result = true;
        HashMap<String, Integer> wantMap = new HashMap<>();
        HashMap<String, Integer> copyMap = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            wantMap.put(want[i], number[i]);  
            // System.out.println(wantMap.get(want[i]));
            // copyMap.put(want[i], number[i]);    
        }
        
        for(int i = 0; i < discount.length - 9; i++){
            copyMap.putAll(wantMap);
            result = true;
            for(int j = i; j < i + 10; j++){
                if(copyMap.containsKey(discount[j])){
                    int val = copyMap.get(discount[j]);
                    copyMap.replace(discount[j], val - 1);
                }
                else{
                    continue;
                }
            }
            // Collection<Integer> values = copyMap.values();
            for(int value : copyMap.values()){
                if(value > 0)
                    result = false;
            }
            if(result)
                answer++;
            copyMap.clear();
            // System.out.println(answer);
        }
        return answer;
    }
}