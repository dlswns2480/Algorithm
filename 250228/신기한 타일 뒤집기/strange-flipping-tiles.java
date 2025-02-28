import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, String> map = new HashMap<>();
        int pos = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);
            if(d == 'R') {
                for(int j = pos; j < pos + x; j++) {
                    map.put(j, "B");
                }
                pos += (x - 1);
            }
            else if(d == 'L') {
                for(int j = pos; j > pos - x; j--) {
                    map.put(j, "W");
                }
                pos -= (x - 1);
            }
        }
        int white = 0;
        int black = 0;
        for(Integer num : map.keySet()) {
            if(map.get(num).equals("B")) black++;
            else white++;
        }
        System.out.print(white + " " + black);
        // Please write your code here.
    }
}