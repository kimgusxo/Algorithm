class Solution {
    public long solution(int w, int h) {
        long none = (long) w+h;
        long answer = (long) w*h;
        
        none -= gcd(w, h);

        return answer-none;
    }
    
    private static long gcd(int w, int h) {
        int c = Math.min(w, h);

        for (int i = c; i >= 1; i--) {
            if (w % i == 0 && h % i == 0) {
                return i;
            }
        }
        return 1;
    }
}