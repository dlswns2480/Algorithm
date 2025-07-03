


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");
        List<Integer> aLst = new ArrayList<>();
        List<Integer> bLst = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            aLst.add(Integer.parseInt(a[i]));
            bLst.add(Integer.parseInt(b[i]));
        }

        Collections.sort(aLst, Collections.reverseOrder());
        Collections.sort(bLst);
        int answer = 0;
        for(int i = 0; i < n; i++) {
            answer += (aLst.get(i) * bLst.get(i));
        }

        System.out.print(answer);

    }
}
