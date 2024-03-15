

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int listen = Integer.parseInt(s[0]);
        int see = Integer.parseInt(s[1]);

        Set<String> set = new HashSet<>();

        for(int i = 0; i < listen; i++){
            set.add(br.readLine());
        }

        List<String> result = new ArrayList<>();
        for(int i = 0; i< see; i++){
            String input = br.readLine();
            if(set.contains(input)){
                result.add(input);
            }
        }
        Collections.sort(result);
        if(result.isEmpty()){
            System.out.print(0);
            return;
        }
        
        System.out.println(result.size());
        
        for(int i = 0; i < result.size() - 1; i++){
            System.out.println(result.get(i));
        }

        System.out.print(result.get(result.size() - 1));




    }

}
