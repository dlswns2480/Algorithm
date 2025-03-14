import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] input = a.toCharArray();
        int len = input.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++) {
            boolean changed = false;
            if(input[i] == '0') {
                input[i] = '1';
                changed = true;
            }
            int sum = 0;
            int idx = 0;
            for(int j = len - 1; j >= 0; j--) {
                String str = String.valueOf(input[j]);
                int toInt = Integer.parseInt(str);
                sum += (Math.pow(2, idx) * toInt);
                idx++;
            }
            if(changed) input[i] = '0';
            max = Math.max(max, sum);
        }

        System.out.print(max);
        // Please write your code here.
    }
}