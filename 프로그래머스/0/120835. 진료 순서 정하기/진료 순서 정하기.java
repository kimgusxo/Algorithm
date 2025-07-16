import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] emergency) {
        List<Integer> list = Arrays.stream(emergency)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> copy = new ArrayList<>(list);

        Collections.sort(copy, Collections.reverseOrder());

        int[] answer = new int[emergency.length];
        int idx = 1;
        for(int el : copy) {
            answer[list.indexOf(el)] = idx;
            idx++;
        }

        return answer;
    }
}