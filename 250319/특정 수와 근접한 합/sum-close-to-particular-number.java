import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                arr[i] = 0;
                arr[j] = 0;
                int sum = getSum(arr);
                min = Math.min(min, Math.abs(s - sum));
            }
        }

        System.out.print(min);
        // Please write your code here.
    }

    private static int getSum(int[] arr) {
        int sum = 0;
        for(int num : arr) {
            sum += num;
        }
        return sum;
    }
}