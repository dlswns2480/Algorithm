
import java.io.*;
import java.util.*;

public class Main {
    static String[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            int sc = scanner.nextInt();
            sum += sc;
            arr[i] = sc;
        }
        A:
        for(int i = 0; i < 9; i++) {
            for(int j = i + 1; j < 9; j++) {
                if(sum - arr[i] - arr[j] == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    break A;
                }
            }
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 9; i++) {
            if(arr[i] == 0) continue;
            sb.append(arr[i]).append("\n");
        }

//        for(int i = 0; i < 9; i++) {
//            System.out.println(arr[i]);
//        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);



    }

}

