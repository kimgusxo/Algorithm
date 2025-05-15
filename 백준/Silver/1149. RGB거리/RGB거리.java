import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] house = new int[N][3];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int ii = 0; ii < 3; ii++) {
                house[i][ii] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][3];

        dp[0][0] = house[0][0];
        dp[0][1] = house[0][1];
        dp[0][2] = house[0][2];
        for(int i = 1; i < N; i++) {
            int r = Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][0] = house[i][0]+r;

            int g = Math.min(dp[i-1][2], dp[i-1][0]);
            dp[i][1] = house[i][1]+g;

            int b = Math.min(dp[i-1][1], dp[i-1][0]);
            dp[i][2] = house[i][2]+b;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            if(min > dp[N-1][i]) {
                min = dp[N-1][i];
            }
        }
        System.out.println(min);
    }
}



