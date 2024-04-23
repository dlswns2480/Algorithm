import java.util.*;
class Solution {
    static boolean[] visited;
    static String start;
    static String end;
    static List<String> lst;
    
    static String[] letters;
    static int answer = 0;
    public int solution(String begin, String target, String[] words) {
        start = begin;
        end = target;
        visited = new boolean[words.length];
        lst = new ArrayList<>();
        letters = words.clone();
        bfs();
        return answer;
    }
    
    private static void bfs(){
        Queue<String> que = new LinkedList<>();
        que.offer(start);
        int L = 0;
        while(!que.isEmpty()){
            int size = que.size();
            for(int j = 0; j < size; j++){
                String poll = que.poll();
                if(poll.equals(end)){
                    answer = L;
                    return;
                }
                for(int i = 0; i < letters.length; i++) {
                    if(canChange(poll, letters[i]) && !visited[i]){
                        visited[i] = true;
                        que.offer(letters[i]);
                    }
                }
            }
            L++;
        }
    }
    
    private static boolean canChange(String origin, String compare) {
        int count = 0;
        for(int i = 0; i < origin.length(); i++) {
            if(origin.charAt(i) != compare.charAt(i)) count++;
        }
        System.out.println(count);
        if(count == 1){
            return true;
        }
        return false;
    }
}