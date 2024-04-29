

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[] unf;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        unf = new int[n + 1];
        for(int i = 0; i <= n; i++) unf[i] = i;
        for(int i = 1; i <= n; i++){
            String[] inputs = br.readLine().split(" ");
            for(int j = 0; j < inputs.length; j++){
                int input = Integer.parseInt(inputs[j]);
                if(input == 1){
                    union(i, j + 1);
                }
            }
        }
        List<Integer> trip = new ArrayList<>();
        String[] s = br.readLine().split(" ");
        for(String str : s) {
            trip.add(Integer.parseInt(str));
        }
        String answer = "YES";
        for(int i = 0; i < trip.size() - 1; i++) {
            if(find(trip.get(i)) != find(trip.get(i + 1))){
                answer = "NO";
                break;
            }
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