

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Long> answers = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int day = sc.nextInt();
            int[] price = new int[day];
            for(int j  = 0; j < day; j++){
                price[j] = sc.nextInt();
            }
            int max = price[price.length - 1];
            long sum = 0;
            for(int j = price.length - 2; j >= 0; j--){
                if(price[j] < max){
                    sum += max - price[j];
                }
                else{
                    max = price[j];
                }
            }
            answers.add(sum);
        }
        for(int i = 0; i < answers.size() - 1; i++){
            System.out.println(answers.get(i));
        }
        System.out.print(answers.get(answers.size() - 1));
    }
}