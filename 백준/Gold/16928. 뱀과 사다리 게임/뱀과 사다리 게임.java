import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n; // 사다리의 수
    static int m; //뱀의 수
    static int[] arr;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[101];
        visited = new boolean[101];
        for(int i = 1; i <= 100; i++){
            arr[i] = i;
        }
        for(int i = 0; i < n + m; i++){
            int key = sc.nextInt();
            int value = sc.nextInt();
            arr[key] = value;
        }

        bfs(1);
        System.out.print(answer);
    }

    private static void bfs(int curr) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(curr);
        int L = 0;
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i < size; i++){
                int poll = que.poll();
                for(int j = 1; j <= 6; j++){
                    if(poll + j <= 100 && !visited[poll + j]){
                        int next = poll + j;
                        int nextStep = arr[next];
                        if(nextStep == 100){
                            answer = L + 1;
                            return;
                        }
                        que.offer(nextStep);
                        visited[nextStep] = true;
                    }
                }
            }
            L++;
        }
    }


}