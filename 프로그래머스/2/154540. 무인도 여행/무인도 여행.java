import java.util.*;
class Solution {
    static boolean[][] visited;
    static String[][] arr;
    static int n;
    static int m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int sum;
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        arr = new String[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            String[] input = maps[i].split("");
            for(int j = 0; j < m; j++){
                arr[i][j] = input[j];
            }
        }
        List<Integer> answers = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sum = 0;
                if(!visited[i][j] && !arr[i][j].equals("X")){
                    sum += Integer.parseInt(arr[i][j]);
                    dfs(i, j);
                    answers.add(sum);        
                }
            }
        }
        int[] result = new int[answers.size()];
        if(answers.size() == 0){
            result = new int[1];
            result[0] = -1;
            return result;
        }
        Collections.sort(answers);
        for(int i = 0; i < answers.size(); i++){
            result[i] = answers.get(i);
        }
        return result;
    }
    
    private static void dfs(int y, int x){
        if(visited[y][x]) return;
        visited[y][x] = true;
        for(int i = 0; i < 4; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(nextY < 0 || nextX < 0 || nextY >= n || nextX >= m || visited[nextY][nextX]) continue;
            if(!arr[nextY][nextX].equals("X")){
                sum += Integer.parseInt(arr[nextY][nextX]);
                dfs(nextY, nextX);
            }
        }
    }
}