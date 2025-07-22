import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        return n % 2 == 0 ? IntStream.range(1, n+1).filter(x -> x%2 == 0).map(x -> (int) Math.pow(x, 2)).sum() : IntStream.range(1, n+1).filter(x -> x % 2 == 1).sum();
    }
}