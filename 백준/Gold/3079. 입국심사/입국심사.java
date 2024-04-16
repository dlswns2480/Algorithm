

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        long n=Long.parseLong(st.nextToken());
        long m=Long.parseLong(st.nextToken());

        long[] arr = new long[(int)n];
        long max = 0;
        long min = 1000000001L;
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        long lt = 0L;
        long rt = max * 1000000000L;
        long answer = rt;

        while(lt <= rt) {
            long mid = (lt + rt) / 2;
            long peopleCount = 0;
            for (int i = 0; i < n; i++) {
                if(peopleCount > m) break;
                peopleCount += mid / arr[i];
            }

            if (peopleCount < m) {
                lt = mid + 1;
            } else {
                answer = mid;
                rt = mid - 1;
            }
        }
        System.out.print(answer);
    }



}