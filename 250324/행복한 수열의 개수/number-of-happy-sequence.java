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
            int prev = grid[i][0];
            for (int j = 1; j < n; j++){
                if(grid[i][j] == prev) {
                    cnt++;
                } else {
                    cnt = 1;
                    prev = grid[i][j];
                }
                if(cnt >= m) {
                    answer++;
                    break;
                }
            }
        }

        for(int j = 0; j < n; j++) {
            int cnt = 1;
            int prev = grid[0][j];
            for(int i = 1; i < n; i++) {
                if(grid[i][j] == prev) {
                    cnt++;
                } else {
                    cnt = 1;
                    prev = grid[i][j];
                }
                if(cnt >= m) {
                    answer++;
                    break;
                }
            }
        }
        System.out.print(answer);
            
        
        // Please write your code here.
    }
}