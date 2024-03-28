
import java.util.Scanner;
import java.util.Stack;


public class Main {
    //
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int answer = 0;
        for(int i = 1; i <= n; i*=10){
            answer += n - i + 1;
        }
        System.out.print(answer);
    }
}
