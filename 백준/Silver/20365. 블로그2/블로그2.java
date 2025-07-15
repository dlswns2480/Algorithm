


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");

        String start = input[0];
        String prev = start;
        int answer = 1;

        for (int i = 1; i < n; i++) {
            if (!input[i].equals(start) && !input[i].equals(prev)) answer++;
            prev = input[i];
        }
        System.out.print(answer);
    }

}
