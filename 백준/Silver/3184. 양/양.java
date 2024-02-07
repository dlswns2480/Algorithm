

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int x, y;
    static int sheep, wolf;

    static String[][] ground;

    static boolean[][] visited;

    static int dfsSheep, dfsWolf;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        x = Integer.parseInt(s[0]);
        y = Integer.parseInt(s[1]);
        ground = new String[x][y];
        visited = new boolean[x][y];

        for(int i = 0; i < x; i++){
            String[] input = br.readLine().split("");
            for(int j = 0; j < y; j++){
                ground[i][j] = input[j];
                if(ground[i][j].equals("o")) sheep++;
                else if(ground[i][j].equals("v")) wolf++;
            }
        }

        int answerSheep = 0;
        int answerWolf = 0;
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                dfsSheep = 0;
                dfsWolf = 0;
                if(!ground[i][j].equals("#") && !visited[i][j]){

                    dfs(i, j);
                }
                if(dfsSheep > dfsWolf){
                    wolf -= dfsWolf;
                }
                else{
                    sheep -= dfsSheep;
                }
            }
        }
        sb.append(sheep).append(" ").append(wolf);
        System.out.print(sb);

    }

    private static void dfs(int cx, int cy) {
        visited[cx][cy] = true;
        if(ground[cx][cy].equals("o")){
            dfsSheep++;
        }
        else if (ground[cx][cy].equals("v")){
            dfsWolf++;
        }
        for(int i = 0;i < 4; i++){
            int gx = cx + dx[i];
            int gy = cy + dy[i];
            if(gx < 0 || gy < 0|| gx >= x || gy >= y) continue;

            if(!visited[gx][gy] && !ground[gx][gy].equals("#")){
                dfs(gx, gy);
            }
        }
    }

}
