import java.util.stream.IntStream;

class Solution {
    public String[] solution(String my_string) {
        return IntStream.rangeClosed(0, my_string.length()-1).mapToObj(my_string::substring).sorted().toArray(String[]::new);
    }
}