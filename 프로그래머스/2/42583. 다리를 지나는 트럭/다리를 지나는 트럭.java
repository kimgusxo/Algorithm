import java.util.*;

class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int idx = 0;
        int time = 1;
        int bridgeWeight = 0;
        Deque<Truck> queue = new ArrayDeque<>();

        while(true) {
            if(idx < truck_weights.length) {
                if(bridgeWeight + truck_weights[idx] <= weight) {
                    queue.add(new Truck(truck_weights[idx], 0));
                    bridgeWeight += truck_weights[idx];
                    idx++;
                }
            }

            for(Truck t : queue) {
                t.distance++;

                if(t.distance == bridge_length) {
                    queue.poll();
                    bridgeWeight -= t.weight;
                }
            }

            time++;

            if(idx == truck_weights.length && queue.isEmpty()) break;
        }

        return time;
    }
}

class Truck {
    int weight;
    int distance;

    public Truck(int weight, int distance) {
        this.weight = weight;
        this.distance = distance;
    }
}