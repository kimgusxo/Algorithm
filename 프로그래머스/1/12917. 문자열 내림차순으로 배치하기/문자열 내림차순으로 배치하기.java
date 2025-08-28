import java.util.*;

class Solution {
    public String solution(String s) {
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        
        StringBuilder sb = new StringBuilder(new String(chs)); 
        return sb.reverse().toString();
    }
}