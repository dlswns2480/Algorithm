


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        String[] input = br.readLine().split("");
        for (String s : input) {
            int num = Integer.parseInt(s);
            if (num == 9) num = 6;
            if (map.getOrDefault(num, 0) == 0) {
                fill();
                answer++;
            }
            map.put(num, map.get(num) - 1);
        }
        System.out.print(answer);

    }

    private static void fill() {
        for(int i = 0; i < 9; i++) {
            if (i == 6) {
                map.put(i, map.getOrDefault(i, 0) + 2);
                continue;
            }
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
    }

}
