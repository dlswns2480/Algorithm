import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int pigeon = sc.nextInt();
            int moveDir = sc.nextInt();
            int value = map.getOrDefault(pigeon, -1);
            if(value == -1){
                map.put(pigeon, moveDir);
                continue;
            } 
            if(value != moveDir) {
                cnt++;
                map.put(pigeon, moveDir);
            }
        }
        System.out.print(cnt);
        

        // Please write your code here.
    }
}