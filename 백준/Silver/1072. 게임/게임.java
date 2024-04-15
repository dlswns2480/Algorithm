
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int prevPercent;
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        prevPercent = (int) ((long) y * 100 / x);
        int lt = 1;
        int rt = (int) 1e9;
        int answer = -1;
        while(lt <= rt){
            int mid = (lt + rt) / 2;
            if(getPercent(mid, x, y)){
                rt = mid - 1;
                answer = mid;
            }
            else{
                lt = mid + 1;
            }
        }
        System.out.print(answer);



    }

    private static boolean getPercent(int mid, int x, int y) {
        int totalGame = x + mid;
        int winGame = y + mid;
        int percent = (int) ((long) winGame * 100 / totalGame);

        if(prevPercent < percent){
            return true;
        }
        return false;
    }


}