

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = 1;
        while (true) {
            int count = 0;
            String[] input = br.readLine().split("");
            if (input[0].equals("-")) break;
            Stack<String> stack = new Stack<>();

            for (int i = 0; i < input.length; i++) {
                if (input[i].equals("{")) stack.push(input[i]);
                else if (input[i].equals("}")) {
                    if (stack.isEmpty()) {
                        stack.push("{");
                        count++;
                    } else stack.pop();
                }
            }
            count += (stack.size() / 2);
            sb.append(testCase++).append(". ").append(count).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
