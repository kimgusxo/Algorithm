import java.util.stream.Stream;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        return Stream.of(intStrs).mapToInt(x -> Integer.parseInt(x.substring(s, s+l))).filter(x -> x > k).toArray();
    }
}