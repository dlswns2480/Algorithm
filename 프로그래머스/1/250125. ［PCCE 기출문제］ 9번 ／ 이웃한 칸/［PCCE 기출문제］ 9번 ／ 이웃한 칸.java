class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String color = board[h][w];
        int len = board.length;
        
        for(int i = 0; i < 4; i++) {
            int ny = h + dy[i];
            int nx = w + dx[i];
            if(ny < 0 || nx < 0 || ny >= len || nx >= len) continue;
            if(board[ny][nx].equals(color)) answer++;
        }
        
        return answer;
    }
}