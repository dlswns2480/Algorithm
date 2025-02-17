

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        String[] str = br.readLine().split(" ");
        for(int j = 0; j < str.length; j++) {
            char[] input = str[j].toCharArray();
            for(int i = 0; i < input.length; i++) {
                if(!Character.isAlphabetic(input[i])){
                    sb.append(input[i]);
                    continue;
                }
                if(isUpper(input[i])) {
                    char ch = incodeUpper(input[i]);
                    sb.append(ch);
                } else {
                    char ch = incodeLower(input[i]);
                    sb.append(ch);
                }
            }
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static char incodeLower(char c) {
        if(c + 13 > 122) {
            int position = c + 13 - 123;
            return (char) (position + 97);
        }
        return (char) (c + 13);
    }

    private static char incodeUpper(char c) {
        if(c + 13 > 90) {
            int position = c + 13 - 91;
            return (char) (position + 65);
        }
        return (char) (c + 13);
    }

    private static boolean isUpper(char s) {
        return Character.isUpperCase(s);
    }



}

