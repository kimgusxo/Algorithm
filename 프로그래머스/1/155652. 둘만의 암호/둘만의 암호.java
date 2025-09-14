class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";

        for(char c : s.toCharArray()) {
            int count = 0;
            int idx = 0;
            while(count < index) {
                if(!skip.contains(String.valueOf((char) ((c-'a'+(idx+1))%26+'a')))) {
                    count++;
                    idx++;
                } else {
                    idx++;
                }
            }
            answer += (char) ((c-'a'+idx)%26+'a');
        }

        return answer;
    }
}