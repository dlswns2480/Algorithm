import java.util.*;
class Solution {
    static int n;
    static boolean[] visited;
    static String[] answer;
    static boolean flag = false;
    static List<Ticket> lst = new ArrayList<>();
    static List<String> route = new ArrayList<>();
    
    static class Ticket implements Comparable<Ticket> {
        String start, end;
        Ticket(String start, String end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Ticket o) {
            if (this.start.equals(o.start)) return this.end.compareTo(o.end);
            return this.start.compareTo(o.start);
        }
    }
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        visited = new boolean[tickets.length];
        
        for (String[] arr : tickets) {
            lst.add(new Ticket(arr[0], arr[1]));
        }
        
        Collections.sort(lst);
        
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).start.equals("ICN")) {
                route.add(lst.get(i).start);
                visited[i] = true;
                dfs(i);
                
                if (route.size() >= n) break;
                visited[i] = false;
                route.remove(route.size() - 1);
                
            }
        }
        
        
        return answer;
    }
    
    private static void dfs(int idx) {
        if (route.size() == n) {
            route.add(lst.get(idx).end);
            flag = true;
            answer = new String[route.size()];
            for (int i = 0; i < route.size(); i++) {
                answer[i] = route.get(i);
            }
            return;
        }
        
        for (int i = 0; i < lst.size(); i++) {
            if (flag) return;
            if (idx == i) continue;
            if (lst.get(idx).end.equals(lst.get(i).start) && !visited[i]) {
                route.add(lst.get(i).start);
                visited[i] = true;
                dfs(i);
                visited[i] = false;
                route.remove(route.size() - 1);
            }
        }
    }
}