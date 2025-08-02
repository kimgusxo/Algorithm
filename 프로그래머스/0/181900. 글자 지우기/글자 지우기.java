import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder(my_string);
        for(int idx : indices) {
            sb.replace(idx, idx+1, " ");
        }
        String answer = sb.toString().replaceAll(" ", "");
        return answer;
    }
}