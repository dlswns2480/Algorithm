


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        List<Integer> packages = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            packages.add(Integer.parseInt(input[0]));
            one.add(Integer.parseInt(input[1]));
        }
        int minOne = Collections.min(one);
        int minPackage = Collections.min(packages);

        int answer = 0;
        while(n >= 6) {
            int min = Math.min(minOne * 6, minPackage);
            answer += min;
            n -= 6;
        }

        if(minOne * n > minPackage) {
            answer += minPackage;
        } else {
            answer += (minOne * n);
        }

        System.out.print(answer);
    }


}
