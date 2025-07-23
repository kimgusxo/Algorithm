import java.util.*;
import java.util.stream.Collectors;

class Solution {
        public int solution(int[] num_list) {
        int a = Integer.parseInt(Arrays.stream(num_list).filter(x -> x % 2 != 0).mapToObj(String::valueOf).collect(Collectors.joining()));
        int b = Integer.parseInt(Arrays.stream(num_list).filter(x -> x % 2 == 0).mapToObj(String::valueOf).collect(Collectors.joining()));
        
        return a+b;
    }
}