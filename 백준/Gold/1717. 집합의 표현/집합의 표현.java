

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int[] unf;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < unf.length; i++) unf[i] = i;
        for(int i = 0; i < m; i++){
            int calcul = sc.nextInt();
            int first = sc.nextInt();
            int second = sc.nextInt();
            if(calcul == 0) {
                union(first, second);
            }
            else if(calcul == 1){
                if (find(first) == find(second)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static void union(int first, int second) {
        int fa = find(first);
        int fb = find(second);
        if(fa != fb) {
            unf[fa] = fb;
        }
    }

    private static int find(int number) {
        if(unf[number] == number) return number;
        return unf[number] = find(unf[number]);
    }


}