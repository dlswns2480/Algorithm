import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] input = str.toCharArray();
        int cnt = 0;
        for(int i = 0; i < input.length; i++) {
            if(input[i] == '(') {
                for(int j = i + 1; j < input.length; j++) {
                    if(input[j] == ')') {
                        cnt++;
                    }
                }
            }
        }

        System.out.print(cnt);
        // Please write your code here.
    }
}