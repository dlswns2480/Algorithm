import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            int maxCnt = 1;
            for (int j = 1; j < n; j++){
                if(grid[i][j] == grid[i][j- 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                maxCnt = Math.max(maxCnt, cnt);
                if(maxCnt >= m) {
                    answer++;
                    break;
                }
            }
        }

        for(int j = 0; j < n; j++) {
            int cnt = 1;
            int maxCnt = 1;
            for(int i = 1; i < n; i++) {
                if(grid[i][j] == grid[i - 1][j]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                maxCnt = Math.max(maxCnt, cnt);
                if(maxCnt >= m) {
                    answer++;
                    break;
                }
            }
        }
        System.out.print(answer);
            
        
        // Please write your code here.
    }
}