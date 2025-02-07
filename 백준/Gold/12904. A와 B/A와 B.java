

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static class Node implements Comparable<Node> {
        int paper, inter;
        public Node(int paper, int inter) {
            this.paper = paper;
            this.inter = inter;
        }

        @Override
        public int compareTo(Node o) {
            return this.paper - o.paper;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        String s = br.readLine();
        String t = br.readLine();
        for(int i = t.length() - 1; i >= 0; i--) {
            if(t.charAt(i) == 'A') {
                t = t.substring(0, i);
            } else {
                t = t.substring(0, i);
                t = reverse(t);
            }
            if(t.equals(s)) {
                answer = 1;
                break;
            }
        }
        System.out.print(answer);


    }

    private static String reverse(String str) {
        StringBuilder reversed = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }


}

