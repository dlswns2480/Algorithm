import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int pos = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            // Please write your code here.
            if(dir == 'R') {
                for(int j = pos; j < pos + x; j++) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
                pos += x;
            }
            else {
                for(int j = pos; j > pos - x; j--) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                }
                pos -= x;
            }
        }

        int answer = 0;
        // System.out.println(map.size());
        for(Integer num : map.keySet()) {
            if(map.get(num) >= 2) {
                answer++;
            }
        }
        System.out.print(answer);
    }
}