
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[size];
        int[] dy = new int[size];

        for(int i = 0; i < s.length; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        dy[0] = arr[0];
        int max = dy[0];
        for(int i = 1; i < size; i++){
            if(dy[i - 1] + arr[i] > arr[i]){
                dy[i] = dy[i - 1] + arr[i];
            }
            else {
                dy[i] = arr[i];
            }
            max = Math.max(max, dy[i]);
        }
        Arrays.sort(dy);
        System.out.print(dy[dy.length - 1]);
    }
}
