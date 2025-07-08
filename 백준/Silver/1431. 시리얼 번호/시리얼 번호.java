


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static class Guitar implements Comparable<Guitar> {
        int length;
        int sum;
        String str;
        public Guitar(int length, int sum, String str) {
            this.length = length;
            this.sum = sum;
            this.str = str;
        }
        @Override
        public int compareTo(Guitar o) {
            if (this.length != o.length) return this.length - o.length;
            if (this.sum != o.sum) return this.sum - o.sum;
            return this.str.compareTo(o.str);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Guitar> guitars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int length = s.length();
            int sum = getSum(s);
            guitars.add(new Guitar(length, sum, s));
        }

        Collections.sort(guitars);

        for(int i = 0; i < guitars.size() - 1; i++) {
            Guitar guitar = guitars.get(i);
            System.out.println(guitar.str);
        }
        System.out.println(guitars.get(guitars.size() - 1).str);
    }

    private static int getSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if(c < 'A' || c > 'Z') {
                sum += Integer.parseInt(String.valueOf(c));
            }
        }
        return sum;
    }

}
