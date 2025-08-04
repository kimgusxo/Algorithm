import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] arr1 = Arrays.copyOfRange(arr, intervals[0][0], intervals[0][1]+1);
        int[] arr2 = Arrays.copyOfRange(arr, intervals[1][0], intervals[1][1]+1);

        
        return IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray();
    }
}