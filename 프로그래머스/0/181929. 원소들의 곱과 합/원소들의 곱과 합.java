import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int a = Arrays.stream(num_list).reduce(1, (x, y) -> x * y);
        int b = (int) Math.pow(Arrays.stream(num_list).sum(), 2);
        return a > b ? 0 : 1;
    }
}