class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int eq = 0;
        int df = 0;
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            eq = 0;
            df = 0;
            
            for(j = i; j < s.length(); j++) {
                if(c == s.charAt(j)) eq++;
                if(c != s.charAt(j)) df++;
                if(eq == df) {
                    answer++;
                    break;
                }
            }
            i = j;
        }
        
        if(eq != df) answer++;
        
        return answer;
    }
}