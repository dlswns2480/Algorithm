
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                String tmp = s.substring(i, j + 1);
                set.add(tmp);
            }
        }

        System.out.print(set.size());





    }

}
