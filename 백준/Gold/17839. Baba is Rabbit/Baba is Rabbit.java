


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    static Map<String, List<String>> dict = new HashMap<>();
    static List<String> answers = new ArrayList<>();
    static int n;
    static Set<String> visited = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            List<String> listOfDict = dict.getOrDefault(input[0], new ArrayList<>());
            listOfDict.add(input[2]);
            dict.put(input[0], listOfDict);
        }
        visited.add("Baba");
        dfs("Baba");

        Collections.sort(answers);
        if(answers.size() == 0) {
            return;
        }
        for(int i = 0; i < answers.size(); i++) {
            sb.append(answers.get(i)).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);

    }

    private static void dfs(String word) {
        List<String> value = dict.getOrDefault(word, new ArrayList<>());
        if(!dict.containsKey(word)) {
            return;
        }
        for (String s : value) {
            if(visited.contains(s)) continue;
            visited.add(s);
            answers.add(s);
            dfs(s);
        }
    }
}
