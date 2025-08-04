import java.util.stream.IntStream;

class Solution {
    public int solution(int[] num_list) {
        return IntStream.range(0, num_list.length).filter(x -> num_list[x] < 0).findFirst().orElse(-1);
    }
}