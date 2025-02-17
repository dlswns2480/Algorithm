

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] pattern = scanner.next().split("\\*");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String input = scanner.next();
            if(input.length() < pattern[0].length() + pattern[1].length()) {
                sb.append("NE").append("\n");
                continue;
            }
            String first = input.substring(0, pattern[0].length());
            String second = input.substring(input.length() - pattern[1].length(), input.length());
            if(first.equals(pattern[0]) && second.equals(pattern[1])) {
                sb.append("DA").append("\n");
            } else {
                sb.append("NE").append("\n");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);

    }



}

