

import java.io.*;
import java.util.*;

public class Main {
    static int m, n, k;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int appleSize = Integer.parseInt(br.readLine());
        arr = new int[n];
        int lt = 1;
        int rt = m;
        int answer = 0;
        for (int i = 0; i < appleSize; i++) {
            int position = Integer.parseInt(br.readLine());
            if(position >= lt && position <= rt) {
                continue;
            } else if(position > rt) {
                int diff = position - rt;
                lt += diff;
                rt += diff;
                answer += diff;
            } else if(position < lt) {
                int diff = lt - position;
                rt -= diff;
                if(lt - diff < 0 ) {
                    lt = 0;
                    answer += diff;
                    continue;
                }
                lt -= diff;
                answer += diff;
            }
        }
        System.out.print(answer);
    }

}

