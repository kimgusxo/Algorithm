import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int n = 1;
        while(n < arr.length) {
            n *= 2;
        }
        return Arrays.copyOf(arr, n);
    }
}