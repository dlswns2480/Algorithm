

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        StringBuilder sb = new StringBuilder(s);
        StringBuilder tb = new StringBuilder(t);

        while(sb.length() < tb.length()){
            if(tb.charAt(tb.length() - 1) == 'A'){
                tb.deleteCharAt(tb.length() - 1);
            }
            else{
                tb.reverse();
                tb.deleteCharAt(0);
            }
        }
        if (sb.toString().equals(tb.toString())) {
            System.out.print(1);
        }
        else{
            System.out.print(0);
        }

    }
}