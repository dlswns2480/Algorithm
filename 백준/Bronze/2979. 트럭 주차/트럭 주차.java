

import java.io.*;
import java.util.*;

public class Main {
    static String[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        int[] fee = new int[4];
        for(int i = 1; i <= 3; i++) {
            fee[i] = scanner.nextInt();
        }
        int[] arr = new int[101];
        for(int i = 0; i < 3; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            for(int j = start; j < end; j++) {
                arr[j]++;
            }
        }
        int answer = 0;
        for(int i = 1; i <= 100; i++) {
            if(arr[i] == 0) continue;
            answer += (arr[i] * fee[arr[i]]);
        }

        System.out.print(answer);


    }

}

