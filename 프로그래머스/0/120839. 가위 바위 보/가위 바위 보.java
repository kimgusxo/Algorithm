import java.util.*;

class Solution {
    public String solution(String rsp) {
        Map<Character, String> map = Map.of('0', "5", '2', "0", '5', "2");
        StringBuilder sb = new StringBuilder();
        for(char c : rsp.toCharArray()) {
            sb.append(map.get(c));
        }
        return sb.toString();
    }
}