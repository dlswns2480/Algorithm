

import java.util.Scanner;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(true){
            String input = sc.next();
            if(input.equals("0")) break;

            int lt = 0;
            int rt = input.length() - 1;

            String answer = "yes";
            for(int i = 0; i < input.length() / 2; i++){
                if(input.charAt(lt) != input.charAt(rt)) answer = "no";
                lt++;
                rt--;
            }
            sb.append(answer).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
