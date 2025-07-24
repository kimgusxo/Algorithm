class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        int cur = numLog[0];
        for(int i = 1; i < numLog.length; i++) {
            int result = numLog[i]-cur;
            switch(result) {
                case 1: answer += 'w'; break;
                case -1: answer += 's'; break;
                case 10: answer += 'd'; break;
                case -10: answer += 'a'; break;
            }
            cur = numLog[i];
        }
        
        
        return answer;
    }
}