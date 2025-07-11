


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        // 7
        //6 1 1 1 2 0 0
        //6 2 3 4 7 5 1
        int[] answer = new int[n];
        for(int i = 0; i < arr.length; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (answer[j] == 0) { // 빈 자리
                    if (cnt == arr[i]) {
                        answer[j] = i + 1;
                        break;
                    }
                    cnt++;
                }
            }
        }
        for (int i = 0; i < answer.length - 1; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.print(answer[answer.length - 1]);
    }

}
