import java.util.stream.*;
class Solution {
    public String[] solution(String myStr) {
        String[] answer = Stream.of(myStr.split("[abc]")).filter(x -> !x.isEmpty()).toArray(String[]::new);
        return answer.length > 0 ? answer : new String[]{"EMPTY"};
    }
}