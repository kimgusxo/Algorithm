import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int[] index_list) {
        return Arrays.stream(index_list).mapToObj(x -> String.valueOf(my_string.charAt(x))).collect(Collectors.joining());
    }
}