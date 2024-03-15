

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int num = Integer.parseInt(s[0]);
        int rememberLength = Integer.parseInt(s[1]);

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < num; i++){
            String word = br.readLine();
            if(word.length() < rememberLength) continue;

            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> words = new ArrayList<>(map.keySet());
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1) != map.get(o2)) return Integer.compare(map.get(o2), map.get(o1));
                if(o1.length() != o2.length()) return o2.length() - o1.length();
                else return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String str : words) {
            sb.append(str).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);


    }

}
