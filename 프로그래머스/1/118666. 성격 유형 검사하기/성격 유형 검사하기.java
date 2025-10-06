import java.util.*;
class Solution {
    static Map<Character, Integer> map = new HashMap<>();
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        for (int i = 0; i < choices.length; i++) {
            int count1 = map.getOrDefault(survey[i].charAt(0), 0);
            int count2 = map.getOrDefault(survey[i].charAt(1), 0);
            if (choices[i] < 4) {
                map.put(survey[i].charAt(0), count1 + Math.abs(choices[i] - 4));
            } else {
                map.put(survey[i].charAt(1), count2 + (choices[i] - 4));
            }
        }
        
        // 1
        if (map.getOrDefault('R', 0) > map.getOrDefault('T', 0)) {
            answer += String.valueOf('R');
        } else if(map.getOrDefault('R', 0) < map.getOrDefault('T', 0)) {
            answer += String.valueOf('T');
        } else answer += String.valueOf('R');
        
        // 2
        if (map.getOrDefault('C', 0) > map.getOrDefault('F', 0)) {
            answer += String.valueOf('C');
        } else if(map.getOrDefault('C', 0) < map.getOrDefault('F', 0)) {
            answer += String.valueOf('F');
        } else answer += String.valueOf('C');
        
        // 3
        if (map.getOrDefault('J', 0) > map.getOrDefault('M', 0)) {
            answer += String.valueOf('J');
        } else if(map.getOrDefault('J', 0) < map.getOrDefault('M', 0)) {
            answer += String.valueOf('M');
        } else answer += String.valueOf('J');
        
        // 4
        if (map.getOrDefault('A', 0) > map.getOrDefault('N', 0)) {
            answer += String.valueOf('A');
        } else if(map.getOrDefault('A', 0) < map.getOrDefault('N', 0)) {
            answer += String.valueOf('N');
        } else answer += String.valueOf('A');
        
        
        return answer;
    }
}