
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] genderInfo = new int[2];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(line[i]);
        }

        int studentSize = Integer.parseInt(br.readLine());
        while (studentSize-- > 0) {
            String[] student = br.readLine().split(" ");
            int gender = Integer.parseInt(student[0]);
            int number = Integer.parseInt(student[1]);

            if (gender == 1) {
                for (int i = number; i <= n; i += number) {
                    arr[i] = Math.abs(arr[i] - 1);
                }
            } else {
                for (int i = number - 1, j = number + 1; i >= 1 && j <= n; i--, j++) {
                    if (arr[i] == arr[j]) {
                        arr[i] = Math.abs(arr[i] - 1);
                        arr[j] = Math.abs(arr[j] - 1);
                    } else {
                        break;
                    }
                }
                arr[number] = Math.abs(arr[number] - 1);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (i % 20 == 0) {
                System.out.println(arr[i]);
                continue;
            }
            System.out.print(arr[i] + " ");
        }
    }


}
