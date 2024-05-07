

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// 가로 : -1, 대각선 : 0, 세로 : -1
public class Main {
    static int[][] arr;
    static int[] dx = {1, 1, 0};
    static int[] dy = {0, -1, -1};
    static int n;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String l = sc.next();
        String r = sc.next();

        int answer = 0;
        if(l.length() == r.length()){
            for(int i = 0; i < r.length(); i++){
                if(l.charAt(i) != r.charAt(i)) break;
                else{
                    if(l.charAt(i) == '8'){
                        answer++;
                    }
                }
            }
        }
        System.out.print(answer);
    }
}