class Solution {
    
    static final int MOD = 1_000_000_007;
    
    public int solution(int n) {
        long[] dp = new long[n+1];

        dp[0] = 1;
        dp[1] = 2;

        for(int i = 2; i <= n; i++) {
            if(i%2 == 0) {
                dp[i] = (dp[i-1] + dp[i-2])%MOD;
            } else {
                dp[i] = ((2*dp[i-1])+dp[i-2])%MOD;
            }
        }

        if(n % 2 == 0) {
            return (int) dp[n];
        } else {
            return 0;
        }
    }
}