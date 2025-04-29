import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> giftValue = new HashMap<>();
        Map<String, Integer> giftRecord = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        for(int i = 0; i < gifts.length; i++) {
            String[] split = gifts[i].split(" ");
            String sender = split[0];
            String receiver = split[1];
            
            //선물 지수 반영
            giftValue.put(sender, giftValue.getOrDefault(sender, 0) + 1);
            giftValue.put(receiver, giftValue.getOrDefault(receiver, 0) - 1);
            
            // 서로 선물 준 기록 반영
            giftRecord.put(gifts[i], giftRecord.getOrDefault(gifts[i], 0) + 1);
        }
        
        
        
        for(int i = 0; i < friends.length; i++) {
            for(int j = i + 1; j < friends.length; j++) {

                String concat = friends[i] + " " + friends[j];
                String reverseConcat = friends[j] + " " + friends[i];
                
                int aTob = giftRecord.getOrDefault(concat, 0);
                int bToa = giftRecord.getOrDefault(reverseConcat, 0);
                
                // System.out.println(friends[i] + " | " + friends[j]);
                // System.out.println(aTob + " | " + bToa);
                
                if(aTob > bToa) {
                    count.put(friends[i], count.getOrDefault(friends[i], 0) + 1);
                } else if(aTob < bToa) {
                    count.put(friends[j], count.getOrDefault(friends[j], 0) + 1);
                } else if(aTob == bToa) {
                    int aValue = giftValue.getOrDefault(friends[i], 0);
                    int bValue = giftValue.getOrDefault(friends[j], 0);
                    
                    if(aValue > bValue) {
                        count.put(friends[i], count.getOrDefault(friends[i], 0) + 1);
                        // count.put(friends[j], count.getOrDefault(friends[j], 0) - 1);
                    } else if(aValue < bValue) {
                        count.put(friends[j], count.getOrDefault(friends[j], 0) + 1);
                        // count.put(friends[i], count.getOrDefault(friends[i], 0) - 1);
                    }
                        
                }
            }
        }
        int max = 0;
        for(String key : count.keySet()) {
            System.out.println("count : " + count.get(key));
            if(max < count.get(key)) {
                max = count.get(key);
            }
        }
        
        return max;
    }
}