class Solution {
    public String solution(String s) {
        String answer = "";
        
        int idx = 0;
        for(char ch : s.toCharArray()) {
            if(ch == ' ') {
                idx = -1;
            }
            
            if(idx%2 == 0) {
                answer += Character.toUpperCase(ch);
            } else {
                answer += Character.toLowerCase(ch);
            }
            idx++;
        }
        
        return answer;
    }
}