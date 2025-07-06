import java.io.*;

class Solution {

        static String[] nums = {"4", "1", "2"};
    
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        while(true) {
            answer.append(nums[n%3]);

            if((double) n/3 <= 1) break;

            n = (n-1)/3;
        }

        return answer.reverse().toString();
    }
}