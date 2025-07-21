import java.util.*;

class Solution {
    public int solution(int[] sides) {
                return (Arrays.stream(sides).sum() - Arrays.stream(sides).max().getAsInt()) > Arrays.stream(sides).max().getAsInt() ? 1 : 2;
    }
}