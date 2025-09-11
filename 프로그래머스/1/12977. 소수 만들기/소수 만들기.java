class Solution {
    
    static int answer = 0;
    
    public int solution(int[] nums) {
        recursive(nums, 0, 0, 0);
        return answer;
    }
    
    public static void recursive(int[] nums, int start, int cnt, int val) {
        if(cnt == 3) {
            answer += isPrime(val) ? 1 : 0;
            return;
        }

        for(int i = start; i <= nums.length-(3-cnt); i++) {
            recursive(nums, i+1, cnt+1, val+nums[i]);
        }
    }

    public static boolean isPrime(int val) {
        for(int i = 2; i < val; i++) {
            if(val%i == 0) return false;
        }
        return true;
    }
}