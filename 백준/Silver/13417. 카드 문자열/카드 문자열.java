


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i++ < n) {
            int number = Integer.parseInt(br.readLine());
            char[] input = br.readLine().replaceAll(" ", "").toCharArray();
            String answer = String.valueOf(input[0]);
            for(int j = 1; j < input.length; j++) {
                if (input[j] <= answer.charAt(0)) {
                    answer = String.valueOf(input[j]) + answer;
                } else if (input[j] > answer.charAt(0)) {
                    answer = answer + String.valueOf(input[j]);
                }
            }
            sb.append(answer).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb.toString());
    }
}
