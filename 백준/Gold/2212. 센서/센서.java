

import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> lst = new ArrayList<>();
    static Map<Integer, Integer> map;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] loc = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            loc[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(loc);

        List<Integer> diff = new ArrayList<>();
        for(int i = 0; i < n - 1; i++) {
            int difference = loc[i + 1] - loc[i];
            diff.add(difference);
        }
        Collections.sort(diff, Collections.reverseOrder());
        int answer = 0;
        for(int i = k - 1; i < n - 1; i++) {
            answer += diff.get(i);
        }
        System.out.print(answer);
    }

}

