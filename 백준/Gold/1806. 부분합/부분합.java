

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int s = Integer.parseInt(first[1]);
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int lt = 0;
        int rt = 1;
        int count = 2;
        int min = Integer.MAX_VALUE;
        int sum = arr[lt] + arr[rt];
        if(arr[lt] >= s){
            System.out.print(1);
            return;
        }
        while(rt < n) {
            if(sum >= s) {
                min = Math.min(min, count);
                sum -= arr[lt];
                lt++;
                count--;
                continue;
            }
            count++;
            rt++;
            if(rt == n) continue;
            sum += arr[rt];
        }
        if(min == Integer.MAX_VALUE){
            System.out.print(0);
            return;
        }
        System.out.print(min);
    }



}