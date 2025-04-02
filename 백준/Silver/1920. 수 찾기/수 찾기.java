

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }


        int m = Integer.parseInt(br.readLine()) ;
        int[] mrr = new int[m];

        String[] input2 = br.readLine().split(" ");
        for(int i = 0; i < m; i++) {
            mrr[i] = Integer.parseInt(input2[i]);
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            boolean flag = false;
            int lt = 0;
            int rt = n - 1;
            while(lt <= rt) {
                int mid = (lt + rt) / 2;
                if(arr[mid] == mrr[i]) {
                    flag = true;
                    sb.append(1).append("\n");
                    break;
                }
                if(arr[mid] > mrr[i]) {
                    rt = mid - 1;
                } else if(arr[mid] < mrr[i]) {
                    lt = mid + 1;
                }
            }
            if(!flag) {
                sb.append(0).append("\n");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);


    }

}

