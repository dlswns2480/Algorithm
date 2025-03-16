import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int dist = 0;
            for(int j = 0; j < n; j++) {
                int shouldMove = j - i;
                if(shouldMove < 0) {
                    shouldMove += n;
                }
                dist += (arr[j] * shouldMove);
            }
            min = Math.min(min, dist);
        }
        System.out.print(min);
    }
}