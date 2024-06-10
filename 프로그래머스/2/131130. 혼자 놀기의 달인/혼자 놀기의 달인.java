import java.util.*;
class Solution {
    static boolean[] visited;
    static int[] card;
    static int count;
    public int solution(int[] cards) {
        int answer = 0;
        card = new int[cards.length + 1];
        for(int i = 1; i <= cards.length; i++) {
            card[i] = cards[i - 1];
        }
        visited = new boolean[card.length];
        List<Integer> box = new ArrayList<>();
        for(int i = 1; i < card.length; i++) {
            if(visited[i]) continue;
            count = 0;
            find(card[i]);
            box.add(count);
        }
        Collections.sort(box, Collections.reverseOrder());
        if(box.size() == 1) {
            return 0;
        }
        answer = box.get(0) * box.get(1);
        return answer;
    }
    
    private static void find(int num) {
        if(visited[num]) return;
        visited[num] = true;
        if(card[num] == num) {
            count++;
            return;
        }
        else {
            count++;
            find(card[num]);
        }
    }
}