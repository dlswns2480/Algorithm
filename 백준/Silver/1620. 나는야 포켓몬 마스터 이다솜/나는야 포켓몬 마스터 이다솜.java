

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> forIndex = new HashMap<>();
        Map<Integer, String> forAnswer = new HashMap<>();
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        for(int i = 1; i <= n; i++) {
            String poketmon = br.readLine();
            forIndex.put(poketmon, i);
            forAnswer.put(i, poketmon);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            String problem = br.readLine();
            if(Character.isDigit(problem.charAt(0))) {
                sb.append(forAnswer.get(Integer.parseInt(problem))).append("\n");
            } else {
                sb.append(forIndex.get(problem)).append("\n");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);


    }



}

