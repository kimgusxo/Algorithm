class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(char c : s.toCharArray()) {
            if(c == ' ') {
                answer += c;
            } else if(c >= 'a' && c <= 'z') {
                int newCh = c+n;
                if(newCh > 'z') {
                    newCh -= 26;
                }
                answer += (char) newCh;
            } else if(c >= 'A' && c <= 'Z') {
                int newCh = c+n;
                if(newCh > 'Z') {
                    newCh -= 26;
                }
                answer += (char) newCh;
            }
        }
        
        return answer;
    }
}