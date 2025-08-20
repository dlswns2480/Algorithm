import java.util.*;
class Solution {
    static int[] unf;
    static class Cost implements Comparable<Cost> {
        int island1, island2, money;
        Cost(int island1, int island2, int money) {
            this.island1 = island1;
            this.island2 = island2;
            this.money = money;
        }
        @Override
        public int compareTo(Cost o) {
            return this.money - o.money;
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        unf = new int[n];
        for (int i = 0; i < n; i++) {
            unf[i] = i;
        }
        List<Cost> costList = new ArrayList<>();
        
        for (int[] info : costs) {
            costList.add(new Cost(info[0], info[1], info[2]));    
        }
        Collections.sort(costList);
        
        for (Cost c : costList) {
            if (find(c.island1) != find(c.island2)) {
                union(c.island1, c.island2);
                answer += c.money;
            }
            
        }
        
        return answer;
    }
    
    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fa] = fb;
    }
    
    private static int find(int num) {
        if (unf[num] == num) return num;
        return unf[num] = find(unf[num]);
    }
}