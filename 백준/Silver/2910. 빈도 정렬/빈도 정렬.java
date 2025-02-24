

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] nc = br.readLine().split(" ");
        int n = Integer.parseInt(nc[0]);
        int c = Integer.parseInt(nc[1]);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        String[] nums = br.readLine().split(" ");

        for(int i = 0; i < nums.length; i++) {
            map.put(Integer.parseInt(nums[i]), map.getOrDefault(Integer.parseInt(nums[i]), 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> lst = new ArrayList<>(map.entrySet());
        lst.sort((o1, o2) -> o2.getValue() - o1.getValue());

        for (Map.Entry<Integer, Integer> integerIntegerEntry : lst) {
            int key = integerIntegerEntry.getKey();
            for (int j = 0; j < map.get(key); j++) {
                sb.append(key).append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

}

