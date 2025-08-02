import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String solution(int q, int r, String code) {
                return IntStream.range(0, code.length()).filter(x -> x%q == r).mapToObj(x -> String.valueOf(code.charAt(x))).collect(Collectors.joining());
    }
}