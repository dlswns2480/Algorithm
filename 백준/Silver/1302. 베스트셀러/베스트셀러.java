

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        
        int max = 0;
        
        
        for(int i = 0; i < num; i++){
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
            max = Math.max(max, map.get(str));
        }

        Set<Entry<String, Integer>> entries = map.entrySet();
        List<String> lst = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entries){
            if(entry.getValue() == max){
                lst.add(entry.getKey());
            }
        }

        Collections.sort(lst);

        System.out.print(lst.get(0));
    }

}
