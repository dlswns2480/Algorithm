import java.util.*;
class Solution {
    static Map<Integer, Integer> income = new HashMap<>(); // 1, 1200
    static Map<String, Integer> index = new HashMap<>(); // john, 0
    static String[] referrals;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        referrals = referral.clone();
        int[] answer = new int[enroll.length];
        
        
        for (int i = 0; i < enroll.length; i++) {
            index.put(enroll[i], i);
        }
        
        for (int i = 0; i < seller.length; i++) {
            int cost = amount[i] * 100;
            String person = seller[i];
            int personIndex = index.get(person);
            
            int tenPercent = (int) ((double) cost * 0.1);
            income.put(personIndex, income.getOrDefault(personIndex, 0) + cost - tenPercent);
            
            sendIncome(person, tenPercent);
        }
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = income.getOrDefault(i, 0);
        }
        
        
        return answer;
    }
    
    private static void sendIncome(String child, int money) {
        int childIndex = index.get(child);
        String parent = referrals[childIndex];
        int tenPercent = (int) ((double) money * 0.1);
        
        if (!parent.equals("-")) {
            int parentIndex = index.get(parent);
            if (tenPercent >= 1) {
                int value = income.getOrDefault(parentIndex, 0) + money - tenPercent;
                income.put(parentIndex, value);
                sendIncome(parent, tenPercent);    
            } else {
                int value = income.getOrDefault(parentIndex, 0) + money;
                income.put(parentIndex, value);
            }
            
        }
    }
}