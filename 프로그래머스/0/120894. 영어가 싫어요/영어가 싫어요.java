class Solution {
    
    static String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    public long solution(String numbers) {
        int idx = 0;
        for(String num : nums) {
            numbers = numbers.replaceAll(num, String.valueOf(idx));
            idx++;
        }
        return Long.parseLong(numbers);
    }
}