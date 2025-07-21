import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        Set<Double> avgs = new TreeSet<>(Collections.reverseOrder());
        ArrayList<Double> list = new ArrayList<>();

        for(int[] arr : score) {
            double avg = (arr[0]+arr[1])/2.0;
            avgs.add(avg);
            list.add(avg);
        }

        int[] answer = new int[score.length];

        int cnt = 1;
        for(double el : avgs) {
            for(int i = 0; i < list.size(); i++) {
                if(el == list.get(i)) {
                    answer[i] = cnt;
                }
            }
            cnt += Collections.frequency(list, el);
        }
        return answer;
    }
}