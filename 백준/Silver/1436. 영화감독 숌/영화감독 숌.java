

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int i = 665;
        int answer = 0;
        while(count < n) {
            i++;
            if(String.valueOf(i).contains("666")) {
                count++;
                answer = i;
            }

        }

        System.out.print(i);
    }

}

