
import java.io.*;
import java.util.*;

public class Main {
    static class Tree implements Comparable<Tree> {
        int length;
        int vector;
        Tree(int length, int vector) {
            this.length = length;
            this.vector = vector;
        }
        @Override
        public int compareTo(Tree o) {
            if(this.vector == o.vector) {
                return this.length - o.length;
            }
            return this.vector - o.vector;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");

        int[] vector = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(input[i]);
        }

        for (int i = 0; i < n; i++) {
            vector[i] = Integer.parseInt(input2[i]);
        }

        Arrays.sort(vector);

        for (int i = 0; i < n; i++) {
            sum += (long) vector[i] * i;
        }
        System.out.print(sum);
    }
}
