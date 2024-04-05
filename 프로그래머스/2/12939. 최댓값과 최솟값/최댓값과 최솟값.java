import java.util.Collections;
import java.util.ArrayList;
class Solution {
    public String solution(String s) {
        String answer = "";
        ArrayList<Integer> forResult = new ArrayList<>();
        String[] sp = s.split(" ");
        int result[] = new int[sp.length];
        for(int i = 0; i < sp.length; i++){
            result[i] = Integer.parseInt(sp[i]);
        }
        for(int n : result){
            forResult.add(n);
        }
        int min = Collections.min(forResult);
        int max = Collections.max(forResult);
        String min_str = String.valueOf(min);
        String max_str = String.valueOf(max);
        answer = min_str + " " + max_str;
        System.out.println(sp[0]);
        return answer;
    }
}