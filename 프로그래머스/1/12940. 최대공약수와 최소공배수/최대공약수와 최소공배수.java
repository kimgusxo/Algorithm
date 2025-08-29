class Solution {
    public int[] solution(int n, int m) {
        long gcd = 1;
        long lcm = 0;
        
        int val1 = Math.min(n, m);
        int val2 = Math.max(n, m);
        
        for(int i = val2; i >= 1; i--) {
            if(val1%i == 0 && val2%i == 0) {
                gcd = Math.max(gcd, i);
            }
            
            if((val1*i)%val2 == 0) {
                lcm = val1*i;
            }
        }
        
        return new int[]{(int) gcd, (int) lcm};
    }
}