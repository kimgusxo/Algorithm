import java.util.*;

class Solution {
    public int solution(int[] num_list, int n) {
        return Arrays.toString(num_list).contains(" " + n + ",") ? 1 : 0;
    }
}