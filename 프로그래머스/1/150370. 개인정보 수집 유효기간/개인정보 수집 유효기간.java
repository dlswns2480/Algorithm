import java.util.*;
class Solution {
    static int year = 12 * 28;
    static String todayInt;
    static Map<String, Integer> ruleKind = new HashMap<>();
    
    static class DateCustom {
        int year, month, day;
        DateCustom(String year, String month, String day) {
            this.year = Integer.parseInt(year);
            this.month = Integer.parseInt(month);
            this.day = Integer.parseInt(day);
        }
        
        public boolean isBan(DateCustom date) {
            // int a = Integer.parseInt(this.year + "" + this.month + "" + this.day);
            // int b = Integer.parseInt(date.year + "" + date.month + "" + date.day);
            // if (a > b) return true;
            // return false;
            if (this.year > date.year) return true;
            if (this.year == date.year && this.month > date.month) return true;
            if (this.year == date.year && this.month == date.month && this.day >= date.day) return true;
            return false;
        }
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        String[] todayArr = today.split("\\.");
        DateCustom todayCustom = new DateCustom(todayArr[0], todayArr[1], todayArr[2]);
        
        for (String term : terms) {
            String[] termArr = term.split(" ");
            ruleKind.put(termArr[0], Integer.parseInt(termArr[1]));
        }
        
        List<Integer> answers = new ArrayList<>();
        int idx = 1;
        for (String p : privacies) {
            String[] privacyInfo = p.split(" ");
            int shouldPlus = ruleKind.get(privacyInfo[1]);
            
            String[] pArr = privacyInfo[0].split("\\.");
            int year = Integer.parseInt(pArr[0]);
            int month = Integer.parseInt(pArr[1]);
            int day = Integer.parseInt(pArr[2]);
            
            int restMonth = 12 - month;
            if (shouldPlus > restMonth) {
                shouldPlus -= (restMonth + 1);
                year++;
                month = 1;
            }
            
            int plusYear = shouldPlus / 12;
            int plusMonth = shouldPlus % 12;
            year += plusYear;
            month += plusMonth;
            
            DateCustom pCustom = new DateCustom(String.valueOf(year), String.valueOf(month), String.valueOf(day));
            System.out.println(year + ", " + month + ", " + day);
            if (todayCustom.isBan(pCustom)) answers.add(idx);
            idx++;
        }
        answer = new int[answers.size()];
        for (int i = 0; i < answers.size(); i++) {
            answer[i] = answers.get(i);
        }
        
        return answer;
    }
}