import java.util.stream.Stream;

class Solution {
    public int solution(int n) {
        return Stream.of((n+"").split("")).mapToInt(Integer::parseInt).sum();
    }
}