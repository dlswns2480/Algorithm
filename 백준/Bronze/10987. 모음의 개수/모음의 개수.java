import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");
        AtomicInteger count = new AtomicInteger();
        Arrays.stream(split).forEach(str -> {
            if ("aeiou".contains(str)) {
                count.getAndIncrement();
            }
        });
        System.out.print(count.get());
    }
}
