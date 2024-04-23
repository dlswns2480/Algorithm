

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr= new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }
        int[] result = new int[2];
        int lt = 0;
        int rt = size - 1;
        int min = Integer.MAX_VALUE;
        while(lt < rt){
            int sum = arr[lt] + arr[rt];
            if(sum == 0){
                result[0] = arr[lt];
                result[1] = arr[rt];
                break;
            }
            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                result[0] = arr[lt];
                result[1] = arr[rt];
            }
            if(sum > 0){
                rt--;
            }
            else if(sum < 0){
                lt++;
            }
        }
        Arrays.stream(result)
            .forEach(element -> System.out.print(element + " "));

    }


}