import java.util.*;
class Solution {
    static int L;
    static int[][] arr;
    static boolean[] visited;
    static int num;
    static int[] answer;
    static int result = 0;
    public int solution(int n, int[][] q, int[] ans) {
        Set<Integer> set = new HashSet<>();
        arr = q.clone();
        num = n;
        answer = ans.clone();
        List<Integer> lst = new ArrayList<>();
        int[] combi = new int[5];
        dfs(combi, 1, 0);
        
        return result;
    }
    
    private static void dfs(int[] combi, int start, int count) {
        if(count == 5) {
            if(check(combi)) {
                result++;
            }
            return;
        }
        
        for(int i = start; i <= num; i++) {
            combi[count] = i;
            dfs(combi, i + 1, count + 1);
        }
    }
    
    private static boolean check(int[] combi) {
        Set<Integer> set = new HashSet<>();
        for(int x : combi) set.add(x);
        for(int i = 0; i < arr.length; i++) {
            int cnt = 0;
            for(int j = 0; j < arr[i].length; j++) {
                if(set.contains(arr[i][j])) {
                    cnt++;
                }
            }
            if(cnt != answer[i]) {
                return false;
            }
        }
        return true;
    }
}