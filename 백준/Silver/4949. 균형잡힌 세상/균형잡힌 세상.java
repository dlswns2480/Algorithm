

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = "";
        while(true) {
            String answer = "yes";
            str = br.readLine();
            if(str.equals(".")) break;
            Stack<String> stack = new Stack<>();
            for(char c : str.toCharArray()) {
                if(c == '(') stack.push("(");
                else if(c == ')') {
                    if(stack.isEmpty() || !stack.peek().equals("(")) {
                        answer = "no";
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
                else if(c == '[') stack.push("[");
                else if(c == ']') {
                    if(stack.isEmpty() || !stack.peek().equals("[")) {
                        answer = "no";
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
            }

            if(!stack.isEmpty() || !stack.isEmpty()) {
                answer = "no";
            }
            sb.append(answer + "\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

}

