import java.util.*;
class Solution {
    static int[] discountList = {10, 20, 30 ,40};
    static int[] discountedList;
    static int[] emoticon;
    static int[][] user;
    
    static int plusAnswer = 0;
    static int priceAnswer = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        discountedList = new int[emoticons.length];
        emoticon = emoticons.clone();
        user = users.clone();
        
        dfs(0);
        
        answer = new int[2];
        answer[0] = plusAnswer;
        answer[1] = priceAnswer;
        return answer;
    }
    
    private void dfs(int L) {
        if (L == discountedList.length) {
            int plusUser = 0;
            int priceSum = 0;
            int totalSum = 0;
            
            for (int i = 0; i < user.length; i++) {
                priceSum = 0;
                for (int j = 0; j < discountedList.length; j++) {
                    if (discountedList[j] >= user[i][0]) {
                        int price = getDiscountPrice(discountedList[j], emoticon[j]);
                        priceSum += price;
                        if(priceSum >= user[i][1]) {
                            plusUser++;
                            priceSum = 0;
                            break;
                        }
                    }
                }
                
                totalSum += priceSum;
            }
            
            if (plusUser > plusAnswer) {
                plusAnswer = plusUser;
                priceAnswer = totalSum;
            } else if (plusUser == plusAnswer && totalSum > priceAnswer) {
                priceAnswer = Math.max(priceAnswer, totalSum);
            }
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                discountedList[L] = discountList[i];
                dfs(L + 1);
            }
        }
        
    }
    
    private int getDiscountPrice(int rate, int price) {
        int minus = (int) (price * (rate / 100.0));
        return price - minus;
    }
}