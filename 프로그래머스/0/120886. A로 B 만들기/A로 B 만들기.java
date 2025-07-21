import java.util.*;

class Solution {
    public int solution(String before, String after) {
        char[] c1 = before.toCharArray();
        Arrays.sort(c1);
        char[] c2 = after.toCharArray();
        Arrays.sort(c2);

        return Arrays.equals(c1, c2) ? 1 : 0;
    }
}