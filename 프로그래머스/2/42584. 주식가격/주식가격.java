class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++) {
            int time = 1;
            int cur = prices[i];
            for(int j = i+1; j < prices.length; j++) {
                if(cur > prices[j] || j == prices.length-1) {
                    answer[i] = time;
                    break;
                }
                time++;
            }
        }
        
        return answer;
    }
}