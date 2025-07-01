


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int[] answer = new int[n];
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(input[j]);
            }
            Arrays.sort(arr);
            boolean left = true;
            int lt = 0;
            int rt = n - 1;
            for(int j = 0; j < n; j++) {
                if(left) {
                    answer[lt++] = arr[j];
                } else {
                    answer[rt--] = arr[j];
                }
                left = !left;
            }
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < n - 1; j++) {
                max = Math.max(max, Math.abs(answer[j] - answer[j + 1]));
            }
            max = Math.max(max, Math.abs(answer[0] - answer[n - 1]));
            sb.append(max).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
