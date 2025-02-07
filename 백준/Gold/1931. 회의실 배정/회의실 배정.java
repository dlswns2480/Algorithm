

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int[][] time = new int[size][2];
        for(int i = 0; i < size; i++){
            String[] input = br.readLine().split(" ");
            time[i][0] = Integer.parseInt(input[0]);
            time[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(time, ((o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        }));
        int answer = 0;
        int prevEndTime = -1;
        for(int i = 0; i < size; i++){
            int currStartTime = time[i][0];
            if(currStartTime >= prevEndTime){
                answer++;
                prevEndTime = time[i][1];
            }
        }



        System.out.print(answer);
    }
}
