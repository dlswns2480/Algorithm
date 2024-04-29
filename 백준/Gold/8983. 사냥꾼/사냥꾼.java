

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] unf;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        long L = sc.nextLong();
        int[][] animal = new int[n][2];
        int[] hunter = new int[m];
        for(int i = 0; i < m; i++){
            hunter[i] = sc.nextInt();
        }
        Arrays.sort(hunter);
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            animal[i][0] = x;
            animal[i][1] = y;
        }
        int answer = 0;
        for(int i = 0; i < n; i++){
            int lt = 0;
            int rt = m - 1;
            while(lt <= rt){
                int mid = (lt + rt) / 2;
                int dist = Math.abs(hunter[mid] - animal[i][0]) + animal[i][1];
                if(dist <= L){
                    answer++;
                    break;
                }
                if(animal[i][0] == hunter[mid]) break;
                if(animal[i][0] > hunter[mid]){
                    lt = mid + 1;
                }
                else{
                    rt = mid - 1;
                }
            }
        }
        System.out.print(answer);
    }


}