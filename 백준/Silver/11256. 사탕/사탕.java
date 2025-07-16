


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] info = br.readLine().split(" ");
            List<Integer> boxInfos = new ArrayList<>();
            int candy = Integer.parseInt(info[0]);
            int box = Integer.parseInt(info[1]);
            for (int i = 0; i < box; i++) {
                String[] boxInfo = br.readLine().split(" ");
                int garo = Integer.parseInt(boxInfo[0]);
                int sero = Integer.parseInt(boxInfo[1]);
                boxInfos.add(garo * sero);
            }
            boxInfos.sort(Collections.reverseOrder());
            int count = 0;
            int idx = 0;
            while (candy > 0) {
                candy -= boxInfos.get(idx);
                idx++;
                count++;
            }
            sb.append(count).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

}
