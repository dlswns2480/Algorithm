

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int first;
    static int[] unf;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] truth = br.readLine().split(" ");
        unf = new int[n + 1];
        for(int i = 1; i <=n; i++) unf[i] = i;

        int[] truePeople = new int[Integer.parseInt(truth[0]) + 1];
        for(int i = 1; i < truth.length; i++){
            truePeople[i] = Integer.parseInt(truth[i]);
        }
        List<Integer> parties = new ArrayList<>();
        for(int i = 0; i < m; i++){
            String[] party = br.readLine().split(" ");
            if(party.length == 2){
                first = Integer.parseInt(party[1]);
            }
            for(int j = 1; j < party.length - 1; j++){
                first = Integer.parseInt(party[j]);
                int second = Integer.parseInt(party[j + 1]);
                union(first, second);
            }
            parties.add(find(first));
        }
        if(Integer.parseInt(truth[0]) == 0){
            System.out.print(m);
            return;
        }
        int answer = 0;
        for(int i = 0; i < parties.size(); i++) {
            answer++;
            for(int j = 1; j < truePeople.length; j++){
                if(find(truePeople[j]) == find(parties.get(i))){

                    answer--;
                    break;
                }
            }
        }

        System.out.print(answer);
    }

    private static void union(int num1, int num2) {
        int fn1 = find(num1);
        int fn2 = find(num2);
        if(fn1 != fn2) unf[fn1] = fn2;
    }

    private static int find(int number) {
        if(unf[number] == number) return unf[number];
        return unf[number] = find(unf[number]);
    }


}