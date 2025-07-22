import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        Set<String> set = new HashSet<>(List.of(s2));
        return (int) Arrays.stream(s1).filter(set::contains).count();
    }
}