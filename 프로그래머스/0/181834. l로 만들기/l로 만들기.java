import java.util.stream.*;

class Solution {
    public String solution(String myString) {
        return myString.chars().mapToObj(x -> x <= 'l' ? "l" : String.valueOf((char) x)).collect(Collectors.joining());
    }
}