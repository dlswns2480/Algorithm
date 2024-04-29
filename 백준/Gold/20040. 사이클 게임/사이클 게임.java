

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[] unf;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n];
        for(int i = 0; i < n; i++) unf[i] = i;
        int answer = 0;
        for(int i = 0; i < m; i++){
            int first = sc.nextInt();
            int sec = sc.nextInt();
            if(find(first) == find(sec)){
                answer = i + 1;
                break;
            }
            union(first, sec);
        }
        System.out.print(answer);
    }
    private static int find(int num){
        if(unf[num] == num) return unf[num];
        return unf[num] = find(unf[num]);
    }
    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }


}