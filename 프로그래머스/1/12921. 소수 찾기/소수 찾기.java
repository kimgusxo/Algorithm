class Solution {
    public int solution(int n) {
        boolean[] prime = new boolean[n+1];
        
        prime[0] = true;
        prime[1] = true;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            int idx = 2;
            while(i*idx <= n) {
                prime[i*idx] = true;
                idx++;
            }
        }
        
        int answer = 0;
        for(boolean p : prime) {
            answer += p ? 0 : 1;
        }
        
        return answer;
    }
}