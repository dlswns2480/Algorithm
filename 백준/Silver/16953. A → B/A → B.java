

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int input = Integer.parseInt(s[0]);
        int goal = Integer.parseInt(s[1]);
        int count = 0;


        while(goal > input){
            String goalToString = String.valueOf(goal);
            if(goal % 2 == 0){
                goal /= 2;
                count++;
            }
            else if(goal % 10 == 1){
                goal /= 10;
                count++;
            }
            else {
                System.out.println(-1);
                return;
            }
        }
        if(goal != input){
            System.out.println(-1);
            return;
        }
        System.out.println(count + 1);

    }

}
