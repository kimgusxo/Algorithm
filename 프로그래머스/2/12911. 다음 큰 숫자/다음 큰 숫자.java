class Solution {
    public int solution(int n) {
        int answer = n+1;

        int s1 = Integer.bitCount(n);

        while(true) {
            int s2 = Integer.bitCount(answer);
            if(s1 == s2) break;
            answer++;
        }

        return answer;
    }
    
}