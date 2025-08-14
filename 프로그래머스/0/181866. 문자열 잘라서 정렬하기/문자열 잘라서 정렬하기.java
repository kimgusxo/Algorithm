import java.util.stream.*;

class Solution {
    public String[] solution(String myString) {
        return Stream.of(myString.split("x")).filter(x -> !x.isEmpty()).sorted().toArray(String[]::new);
    }
}