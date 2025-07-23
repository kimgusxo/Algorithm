class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int el : array) {
            for(char c : String.valueOf(el).toCharArray()) {
                if(c == '7') {
                    answer++;
                }    
            }
        }
        
        return answer;
    }
}