import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[][] dp = new int[N+3][2];

            dp[0][0] = 1;
            dp[0][1] = 0;

            dp[1][0] = 0;
            dp[1][1] = 1;

            dp[2][0] = 1;
            dp[2][1] = 1;

            for(int ii = 3; ii <= N; ii++) {
                dp[ii][0] = dp[ii-1][0] + dp[ii-2][0];
                dp[ii][1] = dp[ii-1][1] + dp[ii-2][1];
            }

            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }
}

