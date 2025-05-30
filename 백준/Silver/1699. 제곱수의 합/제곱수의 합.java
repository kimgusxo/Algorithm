import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        dp[0] = 0;
        for(int i = 1; i <= N; i++) {
            int el = (int) Math.sqrt(i);

            if(Math.pow(el, 2) == i) {
                dp[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for(int ii = 1; ii < i; ii++) {
                    min = Math.min(min, dp[ii] + dp[i-ii]);
                }
                dp[i] = min;
            }
        }

        System.out.println(dp[N]);
    }
}

