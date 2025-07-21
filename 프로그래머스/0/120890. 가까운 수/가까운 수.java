import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
                return Arrays.stream(array).sorted().boxed().sorted(Comparator.comparing(x -> Math.abs(x-n))).findFirst().get();
    }
}