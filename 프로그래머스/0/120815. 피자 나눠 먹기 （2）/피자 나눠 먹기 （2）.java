class Solution {
    public int solution(int n) {
        int piece = 6;
        for(int i = 6; i > 0; i--) {
            if(n%i == 0 && piece%i == 0) {
                n /= i;
                piece /= i;
            }
        }
        
        return n;
    }
}