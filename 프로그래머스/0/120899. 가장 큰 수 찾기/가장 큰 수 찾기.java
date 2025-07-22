import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] array) {
        return new int[]{Arrays.stream(array).max().getAsInt(), Arrays.stream(array).boxed().collect(Collectors.toList()).indexOf(Arrays.stream(array).max().getAsInt())};
    }
}