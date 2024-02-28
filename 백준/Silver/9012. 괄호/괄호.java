

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < num; i++){
            stack.clear();
            String gual = br.readLine();

            for(int j = 0; j < gual.length(); j++){
                char ch = gual.charAt(j);
                if(ch == '('){
                    stack.push(String.valueOf(ch));
                }
                else{
                    if(stack.isEmpty()){
                        stack.push(String.valueOf(ch));
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }

            }
            if(stack.isEmpty()){
                sb.append("YES").append("\n");
            }
            else{
                sb.append("NO").append("\n");
            }
        }

        sb.deleteCharAt(sb.length() - 1);

        System.out.print(sb);
    }

}
