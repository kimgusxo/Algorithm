import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int[] query : queries) {
            int start = query[0];
            int end = query[1];

            int target = query[2];
            int min = Integer.MAX_VALUE;

            for(int i = start; i <= end; i++) {
                if(arr[i] > target) {
                    min = Math.min(min, arr[i]);
                }
            }

            if(min == Integer.MAX_VALUE) {
                answer.add(-1);
            } else {
                answer.add(min);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}