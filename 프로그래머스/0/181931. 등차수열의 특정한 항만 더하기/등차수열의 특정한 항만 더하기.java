import java.util.stream.IntStream;

class Solution {
    public int solution(int a, int d, boolean[] included) {
        return IntStream.rangeClosed(0, included.length-1)
            .filter(idx -> included[idx])
            .map(idx -> a+d*idx)
            .sum();
    }
}