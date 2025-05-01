import java.util.*;
class Solution {
    static String[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Node {
        int y, x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        arr = new String[storage.length + 2][storage[0].length() + 2];
        fill();
        for(int i = 1; i <= storage.length; i++) {
            String[] split = storage[i - 1].split("");
            for(int j = 1; j <= split.length; j++) {
                arr[i][j] = split[j - 1];
            }
        }
        
        
        
        for(int i = 0; i < requests.length; i++) {
            if(requests[i].length() == 2) {
                deleteAll(requests[i]);
            } else if(requests[i].length() == 1) {
                bfs(requests[i]);
            }
        }
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(!arr[i][j].equals("1")) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private static void bfs(String str) {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(0, 0));
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        visited[0][0] = true;
        
        while(!que.isEmpty()) {
            Node curr = que.poll();
            for(int i = 0; i < 4; i++) {
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];
                if(ny < 0 || nx < 0 || ny >= arr.length || nx >= arr[0].length || visited[ny][nx]) continue;
                if(arr[ny][nx].equals(str)) {
                    arr[ny][nx] = "1";
                    visited[ny][nx] = true;
                } else if(arr[ny][nx].equals("1")) {
                    que.offer(new Node(ny, nx));
                    visited[ny][nx] = true;   
                }
            }
        }
    }
    
    private static void deleteAll(String str) {
        str = String.valueOf(str.charAt(0));
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j].equals(str)) {
                    arr[i][j] = "1";
                }
            }
        }
    }
    
    private static void fill() {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = "1";
            }
        }
    }
    
}