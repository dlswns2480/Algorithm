

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int first = Integer.parseInt(split[0]);
        int second = Integer.parseInt(split[1]);
        System.out.print(first + second);
    }


}
