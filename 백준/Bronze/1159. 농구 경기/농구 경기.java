

import java.io.*;
import java.util.*;

public class Main {
    static String[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        int[] charrArr = new int[26];
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            int input = scanner.next().charAt(0);
            charrArr[input - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(charrArr[i] >= 5) {
                char c = (char) (i + 97);
                sb.append(c);
            }
        }

        if(sb.length() == 0) {
            System.out.print("PREDAJA");
        } else {
            System.out.print(sb);
        }
    }

}

