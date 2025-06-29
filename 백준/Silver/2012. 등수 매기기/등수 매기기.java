


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long result = 0;
        for(int i = 1; i <= n; i++) {
            result += Math.abs(arr[i] - i);
        }

        System.out.print(result);
    }
}
