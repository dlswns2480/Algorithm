

import java.io.*;
import java.util.*;

public class Main {
    static String[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        String init = br.readLine();
        String[] s = init.split("");
        Stack<String> stack = new Stack<>();
        for(String str : s) {
            stack.push(str);
        }
        String result = "";
        int size = stack.size();
        for(int i = 0; i < size; i++) {
            result += stack.pop();
        }
        if (init.equals(result)) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }

    }

}

