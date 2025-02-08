

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            int third = scanner.nextInt();
            if (first == 0) break;
            List<Integer> list = new ArrayList<>(Arrays.asList(first, second, third));
            Collections.sort(list);
            if (list.get(0) + list.get(1) <= list.get(2)) {
                sb.append("Invalid").append("\n");
            } else if (Objects.equals(list.get(0), list.get(1)) && Objects.equals(list.get(1),
                list.get(2))) {
                sb.append("Equilateral").append("\n");
            } else if (Objects.equals(list.get(0), list.get(1))
                || Objects.equals(list.get(0), list.get(2)) || Objects.equals(list.get(1),
                list.get(2))) {
                sb.append("Isosceles").append("\n");
            } else {
                sb.append("Scalene").append("\n");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);


    }

}

