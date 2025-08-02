class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        for(char c : my_string.toCharArray()) {
            int x = 0;
            
            if(c <= 'z' && c >= 'a') {
                x = c-'a'+26;
            } else if(c <= 'Z' && c >= 'A') {
                x = c-'A';
            }
            
            answer[x]++;
        }
        return answer;
    }
}