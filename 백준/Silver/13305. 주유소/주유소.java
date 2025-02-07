

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dist = new int[n - 1];
        int[] price = new int[n];
        for(int i = 0; i < n - 1; i++) {
            dist[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }
        int sum = 0;
        int minPrice = price[0];
        sum += (minPrice * dist[0]);
        for(int i = 1; i < n - 1; i++) {
            if(price[i] < minPrice) {
                minPrice = price[i];
            }
            sum += (minPrice * dist[i]);
        }
        System.out.print(sum);
    }


}

