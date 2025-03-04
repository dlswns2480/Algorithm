import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[2001][2001];
        int rect1_x1 = sc.nextInt() + 1000;
        int rect1_y1 = sc.nextInt()+ 1000;
        int rect1_x2 = sc.nextInt()+ 1000;
        int rect1_y2 = sc.nextInt()+ 1000;
        int rect2_x1 = sc.nextInt()+ 1000;
        int rect2_y1 = sc.nextInt()+ 1000;
        int rect2_x2 = sc.nextInt()+ 1000;
        int rect2_y2 = sc.nextInt()+ 1000;

        for(int i = rect1_y1; i < rect1_y2; i++) {
            for(int j = rect1_x1; j < rect1_x2; j++) {
                arr[i][j] = 1;
            }   
        }

        for(int i = rect2_y1; i < rect2_y2; i++) {
            for(int j = rect2_x1; j < rect2_x2; j++) {
                arr[i][j] = 2;
            }
        }

        int bigx = Integer.MIN_VALUE;
        int bigY = Integer.MIN_VALUE;
        int smallx = Integer.MAX_VALUE;
        int smally = Integer.MAX_VALUE;
        int cnt = 0;
        for(int i = 0; i < 2001; i++) {
            for(int j = 0; j < 2001; j++) {
                if(arr[i][j] == 1) {
                    cnt++;
                    // System.out.println("x index : " + j + " y index : " + i);
                    bigx = Math.max(bigx, j);
                    bigY = Math.max(bigY, i);
                    smallx = Math.min(smallx, j);
                    smally = Math.min(smally, i);
                }
            }
        }
        int width = 0;
        // System.out.println(cnt);
        if(cnt == 0) {
            width = 0;
        } else {
            width = (bigY - smally + 1) * (bigx - smallx + 1);
        }
        System.out.print(width);
    }
}