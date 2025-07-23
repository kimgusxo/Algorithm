import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] num_list) {
        int a = num_list[num_list.length - 1];
        int b = num_list[num_list.length - 2];
        List<Integer> list = Arrays.stream(num_list).boxed().collect(Collectors.toList());

        if(a > b) {
            list.add(a-b);
        } else {
            list.add(a*2);
        }

        return list.stream().mapToInt(x -> x).toArray();
    }
}