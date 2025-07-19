

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int truckSize = Integer.parseInt(info[0]);
        int bridge = Integer.parseInt(info[1]);
        int weight = Integer.parseInt(info[2]);

        String[] t = br.readLine().split(" ");
        Queue<Integer> trucks = new LinkedList<>();
        for (int i = 0; i < truckSize; i++) {
            trucks.offer(Integer.parseInt(t[i]));
        }
        Queue<Integer> bridgeTruck = new LinkedList<>();
        for (int i = 0; i < bridge; i++) {
            bridgeTruck.offer(0);
        }

        int time = 0;
        int currWeight = 0;
        while (!bridgeTruck.isEmpty()) {
            currWeight -= bridgeTruck.poll();
            if (!trucks.isEmpty()) {
                Integer truck = trucks.peek();
                if (currWeight + truck <= weight) {
                    bridgeTruck.offer(trucks.poll());
                    currWeight += truck;
                } else {
                    bridgeTruck.offer(0);
                }
            }
            time++;
        }
        System.out.print(time);
    }

}
