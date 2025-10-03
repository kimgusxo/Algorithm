import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }
    
    public static void dfs(int[] numbers, int depth, int sum, int target) {
        if(depth == numbers.length) {
            if(sum == target) {
                answer++;
            }
            return;
        } else {
            int plus = sum + numbers[depth];
            int minus = sum - numbers[depth];

            dfs(numbers, depth+1, plus, target);
            dfs(numbers, depth+1, minus, target);
        }
    }
}