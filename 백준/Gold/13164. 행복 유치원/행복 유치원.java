


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int[] arr = new int[n];
        String[] arrStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        Arrays.sort(arr);
        PriorityQueue<Integer> diff = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            diff.offer(arr[i + 1] - arr[i]);
            sum += arr[i + 1] - arr[i];
        }

        for(int i = 0; i < k - 1; i++) {
            sum -= diff.poll();
        }

        System.out.print(sum);
    }


}
