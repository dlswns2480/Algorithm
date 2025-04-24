import java.util.*;
class Solution {
    static int length = 0;
    static int nLimit = 0;
    static int mLimit = 0;
    static int[][] infos;
    static int min = Integer.MAX_VALUE;
    static Set<String> set = new HashSet<>();

    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        length = info.length;
        nLimit = n;
        mLimit = m;
        infos = info.clone();
        dfs(0, 0, 0);
        
        if(min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
    
    private static void dfs(int L, int alimit, int blimit) {
        
        if(alimit >= nLimit || blimit >= mLimit) {
            return;
        }
        if(min == 0) {
            return;
        }
        if(L == length) {
            min = Math.min(min, alimit);
            return;
        }
        set.add(L + "," + alimit + "," + blimit);
        
        String value = (L + 1) + "," + (infos[L][0] + alimit) + "," + blimit;
        
        if(!set.contains(value)) dfs(L + 1, infos[L][0] + alimit, blimit);
        
        value = (L + 1) + "," + alimit + "," + (infos[L][1] + blimit);
        
        if(!set.contains(value)) dfs(L + 1, alimit, infos[L][1] + blimit);
        
        
        // for(int i = 0; i < length; i++) {
        //     dfs(L + 1, infos[i][0] + alimit, blimit);
        //     dfs(L + 1, alimit, infos[i][1] + blimit);
        // }
        
    }
}