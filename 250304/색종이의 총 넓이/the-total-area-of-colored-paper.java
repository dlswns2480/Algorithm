import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            for(int j = y[i]; j < y[i] + 8; j++) {
                for(int k = x[i]; k < x[i] + 8; k++) {
                    String key = String.valueOf(j) + String.valueOf(k);
                    map.put(key, 1);
                }
            }
        }
        System.out.print(map.size()+ 2);
        // Please write your code here.
    }
}