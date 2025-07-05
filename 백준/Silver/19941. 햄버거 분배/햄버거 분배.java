


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        String[] arr = br.readLine().split("");
        boolean[] visited = new boolean[n];
        int answer = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i].equals("H")) continue;
            boolean flag = false;
            for(int j = i - k; j < i; j++) {
                if(j < 0) continue;
                if(!visited[j] && arr[j].equals("H")) {
                    visited[j] = true;
                    answer++;
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                for(int j = i + 1; j <= i + k; j++) {
                    if(j >=n) continue;
                    if(!visited[j] && arr[j].equals("H")) {
                        visited[j] = true;
                        answer++;
                        break;
                    }
                }
            }
        }

        System.out.print(answer);
    }


}
