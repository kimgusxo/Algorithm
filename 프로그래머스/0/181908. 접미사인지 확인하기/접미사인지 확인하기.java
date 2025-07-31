import java.util.stream.IntStream;
class Solution {
    public int solution(String my_string, String is_suffix) {
        return (int) IntStream.rangeClosed(0, my_string.length()-1).mapToObj(my_string::substring).filter(s -> s.equals(is_suffix)).count() > 0 ? 1 : 0;
    }
}