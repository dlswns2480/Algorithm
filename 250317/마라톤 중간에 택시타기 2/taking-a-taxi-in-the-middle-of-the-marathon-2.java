import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < n - 1; i++) {
            int dist = 0;
            int prevx = x[0];
            int prevy = y[0];
            for(int j = 1; j < n; j++) {
                if(i == j) continue;
                dist += (Math.abs(x[j] - prevx) + Math.abs(y[j] - prevy));
                prevx = x[j];
                prevy = y[j];
            }
            min = Math.min(min, dist);
        }
        System.out.print(min);
        // Please write your code here.
    }
}