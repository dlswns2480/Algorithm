

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int lt = 0;
        int rt = arr[n-1];
        int answer = 0;

        while(lt <= rt){
            int mid = (lt + rt) / 2;
            if(count(arr, mid) < c){
                rt = mid - 1;
            }
            else if(count(arr, mid) >= c){
                lt = mid + 1;
                answer = mid;
            }
        }
        System.out.print(answer);
    }

    private static int count(int[] array, int limit) {
        int prev = array[0];
        int count = 1;
        for(int i = 1; i < array.length; i++){
            if(array[i] - prev >= limit){
                prev = array[i];
                count++;
            }
        }
        return count;
    }


}