


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    static Map<String, List<String>> dict = new HashMap<>();
    static List<String> answers = new ArrayList<>();
    static int n;
    static Set<String> visited = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        long m = Long.parseLong(nm[1]);
        long[] trees = new long[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            trees[i] = Long.parseLong(input[i]);
        }

        long lt = 0;
        long rt = Arrays.stream(trees).max().getAsLong();
        long answer = 0;
        while(lt <= rt) {
            long mid = (lt + rt) / 2;
            long height = getHeight(trees, mid);
            if(height >= m) {
                lt = mid + 1;
                answer = mid;
            } else{
                rt = mid - 1;
            }
        }

        System.out.print(answer);

    }

    private static long getHeight(long[] trees, long mid) {
        long sum = 0;
        for(int i = 0; i < trees.length; i++) {
            if(trees[i] - mid < 0) {
                continue;
            }
            sum += trees[i] - mid;
        }
        return sum;
    }


}
