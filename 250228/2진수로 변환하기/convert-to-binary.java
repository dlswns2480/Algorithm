import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack();
        while(true) {
            if(n < 2) {
                stack.push(n);
                break;
            }

            stack.push(n % 2);
            n /= 2;
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        // Please write your code here.
    }
}