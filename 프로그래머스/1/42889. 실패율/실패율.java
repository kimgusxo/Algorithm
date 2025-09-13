import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {    
        int[] prefixSum = new int[N+1];
        int[] challenges = new int[N+1];
        for(int stage : stages) {
            challenges[stage-1]++;
            for(int i = 0; i < stage; i++) {
                prefixSum[i]++;
            }
        }

        Map<Integer, Double> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            if(prefixSum[i] > 0) {
                map.put(i+1, (double) challenges[i] / (double) prefixSum[i]);
            } else {
                map.put(i+1, 0.0);
            }
        }

        List<Integer> entry = new ArrayList<>(map.keySet());
        entry.sort((o1, o2) -> {
            int c = Double.compare(map.get(o2), map.get(o1));
            if (c != 0) return c;
            return Integer.compare(o1, o2);
        });

        return entry.stream().mapToInt(x->x).toArray();
    }
}