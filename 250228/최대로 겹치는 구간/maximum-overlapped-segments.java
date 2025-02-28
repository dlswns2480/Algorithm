import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[201];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            for(int j = start; j < end; j++) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        for(Integer num : map.keySet()) {
            int value = map.get(num);
            max = Math.max(max, value);
        }
        System.out.print(max);
    }
}