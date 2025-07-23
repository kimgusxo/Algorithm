import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        ArrayList<Character> list = new ArrayList<>();
        for(char c : s.toCharArray()) {
            if(s.length() - s.replaceAll(String.valueOf(c), "").length() == 1) {
                list.add(c);
            }
        }

        Collections.sort(list);

        return list.stream().map(String::valueOf).collect(Collectors.joining());
    }
}