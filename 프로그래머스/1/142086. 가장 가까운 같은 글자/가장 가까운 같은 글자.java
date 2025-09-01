class Solution {
    
    static int[] alphabet = new int[26];
    
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        int idx = 0;
        for(char c : s.toCharArray()) {
            if(alphabet[c-'a'] == 0) {
                alphabet[c-'a'] = idx+1;
                answer[idx] = -1;
            } else {
                answer[idx] = idx-alphabet[c-'a']+1;
                alphabet[c-'a'] = idx+1;
            }
            idx++;
        }
        
        return answer;
    }
}