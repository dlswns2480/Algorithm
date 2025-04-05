

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int n;
    static int relation;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        visited = new boolean[n];
        relation = Integer.parseInt(s[1]);

        for(int i  = 0; i < relation; i++) {
            String[] s1 = br.readLine().split(" ");
            int first = Integer.parseInt(s1[0]);
            int second = Integer.parseInt(s1[1]);
            list.get(first).add(second);
            list.get(second).add(first);
        }
//        for(int i = 0; i < n; i++) {
//            System.out.println("index : " + i);
//            for(int j = 0; j < list.get(i).size(); j++) {
//                System.out.print(list.get(i).get(j) + " " );
//            }
//            System.out.println();
//        }
//
        for(int i = 0; i < n; i++) {
            if(answer == 1) break;
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, 1);
                visited[i] = false;
            }

        }

        System.out.print(answer);
    }

    private static void dfs(int num, int count) {
        if(count == 5) {
            answer = 1;
            return;
        }

        List<Integer> listOflist = list.get(num);
        int size = listOflist.size();
        for(int i = 0; i < size; i++) {
            if(!visited[listOflist.get(i)]) {
                visited[listOflist.get(i)] = true;
                dfs(listOflist.get(i), count + 1);
                visited[listOflist.get(i)] = false;
            }
        }
    }
}



