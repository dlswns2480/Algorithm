import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> box = new HashMap<>();
        
        for(int num : tangerine){
            if(box.containsKey(num)){
                int origin = box.get(num);
                box.put(num, origin + 1);
            }
            else{
                box.put(num, 1);
            }
        }
        
        ArrayList<Integer> lst = new ArrayList<>();
        for(int n : box.keySet()){
            lst.add(box.get(n));
            // System.out.println(n + " " + box.get(n));
        }
        Collections.sort(lst, Collections.reverseOrder());
        int sum = 0;
        int cnt = 0;
        for(int number : lst){
            answer++;
            // System.out.println(number);
            k -= number;
            if(k <= 0){
                return answer;
            }
            
        }
        return answer;
    }
}