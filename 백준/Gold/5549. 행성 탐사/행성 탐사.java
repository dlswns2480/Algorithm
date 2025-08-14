
import java.io.*;
import java.util.*;


public class Main {
    static int update = 0;
    static List<Candidate> candidates = new ArrayList<>();
    static class Candidate implements Comparable<Candidate> {
        int studentNum;
        int count;
        int updatedRank; // 높을수록 최근에 업데이트
        Candidate(int studentNum, int count, int updatedRank) {
            this.studentNum = studentNum;
            this.count = count;
            this.updatedRank = updatedRank;
        }
        @Override
        public int compareTo(Candidate o) {
            if (this.count == o.count) return o.updatedRank - this.updatedRank;
            return o.count - this.count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int m = Integer.parseInt(init[0]);
        int n = Integer.parseInt(init[1]);
        int k = Integer.parseInt(br.readLine());

        int[][] jungle = new int[m + 1][n + 1];
        int[][] ocean = new int[m + 1][n + 1];
        int[][] ice = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            String[] input = br.readLine().split("");
            for (int j = 1; j <= n; j++) {
                String s = input[j - 1];
                if (s.equals("J")) {
                    jungle[i][j] = jungle[i - 1][j] + jungle[i][j - 1] - jungle[i - 1][j - 1] + 1;
                    ocean[i][j] = ocean[i - 1][j] + ocean[i][j - 1] - ocean[i - 1][j - 1];
                    ice[i][j] = ice[i - 1][j] + ice[i][j - 1] - ice[i - 1][j - 1];
                } else if (s.equals("O")) {
                    ocean[i][j] = ocean[i - 1][j] + ocean[i][j - 1] - ocean[i - 1][j - 1] + 1;
                    jungle[i][j] = jungle[i - 1][j] + jungle[i][j - 1] - jungle[i - 1][j - 1];
                    ice[i][j] = ice[i - 1][j] + ice[i][j - 1] - ice[i - 1][j - 1];
                } else {
                    ice[i][j] = ice[i - 1][j] + ice[i][j - 1] - ice[i - 1][j - 1] + 1;
                    jungle[i][j] = jungle[i - 1][j] + jungle[i][j - 1] - jungle[i - 1][j - 1];
                    ocean[i][j] = ocean[i - 1][j] + ocean[i][j - 1] - ocean[i - 1][j - 1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            String[] query = br.readLine().split(" ");
            int y1 = Integer.parseInt(query[0]);
            int x1 = Integer.parseInt(query[1]);
            int y2 = Integer.parseInt(query[2]);
            int x2 = Integer.parseInt(query[3]);

            int jungleCount = jungle[y2][x2] - jungle[y2][x1 - 1] - jungle[y1 - 1][x2] + jungle[y1 - 1][x1 - 1];
            int oceanCount = ocean[y2][x2] - ocean[y2][x1 - 1] - ocean[y1 - 1][x2] + ocean[y1 - 1][x1 - 1];
            int iceCount = ice[y2][x2] - ice[y2][x1 - 1] - ice[y1 - 1][x2] + ice[y1 - 1][x1 - 1];

            sb.append(jungleCount).append(" ").append(oceanCount).append(" ").append(iceCount).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
