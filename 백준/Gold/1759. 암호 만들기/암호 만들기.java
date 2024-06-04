

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int L;
    static int C;
    static boolean[] visited;
    static String[] alphabet;
    static List<String> answers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        L = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        alphabet = br.readLine().split(" ");
        Arrays.sort(alphabet);
        visited = new boolean[alphabet.length];

        dfs(0);
        for(String str : answers) {
            System.out.println(str);
        }
    }

    private static void dfs(int level) {
        if(level == alphabet.length) {
            String str = "";
            for(int i = 0; i < visited.length; i++){
                if(visited[i]) {
                    str += alphabet[i];
                }
            }
            if(!conditionCheck(str)) return;
            if(str.length() != L) return;
            answers.add(str);
        }
        else {
            visited[level] = true;
            dfs(level + 1);
            visited[level] = false;
            dfs(level + 1);
        }
    }

    private static boolean conditionCheck(String str) {
        int vowelCount = 0;
        int consonantCount = 0;
        for(char s : str.toCharArray()) {
            if(s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u'){
                vowelCount++;
            }
            else{
                consonantCount++;
            }
        }
        if(vowelCount >= 1 && consonantCount >= 2) return true;
        return false;
    }




}