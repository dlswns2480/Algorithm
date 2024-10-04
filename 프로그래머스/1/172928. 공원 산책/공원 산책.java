import java.util.*;
class Solution {
    static int sero;
    static int garo;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int[] solution(String[] park, String[] routes) {
        sero = park.length;
        garo = park[0].length();
        int[] answer = new int[2];
        String[][] parks = new String[sero][garo];
        
        
        Map<String, Integer> map = new HashMap<>();
        map.put("E", 0);
        map.put("S", 1);
        map.put("W", 2);
        map.put("N", 3);
        int startX = 0;
        int startY = 0;
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length(); j++) {
                parks[i][j] = String.valueOf(park[i].charAt(j));
                if(parks[i][j].equals("S")) {
                    startY = i;
                    startX = j;
                }
            }
        }
        for(int i = 0; i < routes.length; i++) {
            String[] dict = routes[i].split(" ");
            int nextIdx = map.get(dict[0]);
            int dist = Integer.parseInt(dict[1]);
            int currY = startY;
            int currX = startX;
            for(int j = 0; j < dist; j++) {
                int nextY = currY + dy[nextIdx];    
                int nextX = currX + dx[nextIdx];
                if(checkRange(nextY, nextX) || parks[nextY][nextX].equals("X")){
                    currY = startY;
                    currX = startX;
                    break;
                }  
                currY = nextY;
                currX = nextX;
            }
            
            startY = currY;
            startX = currX;
            
            System.out.println(currY + " " + currX);
            
        }
        answer[0] = startY;
        answer[1] = startX;
        return answer;
    }
    
    private static boolean checkRange(int y, int x) {
        return y < 0 || x < 0 || y >= sero || x >= garo;
    }
}