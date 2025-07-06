


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int base = 0;

        int pt = 0;
        while (base++ <= 100_000) {
            String temp = String.valueOf(base);
            for(int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == s.charAt(pt)) {
                    pt++;
                }

                if(pt == s.length()) {
                    System.out.print(base);
                    return;
                }
            }
        }
    }
}
