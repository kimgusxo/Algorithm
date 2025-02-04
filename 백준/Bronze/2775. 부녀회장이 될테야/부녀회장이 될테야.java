import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer c = Integer.parseInt(br.readLine());

        for(int i = 0; i < c; i++) {
            Integer floor = Integer.parseInt(br.readLine());
            Integer room = Integer.parseInt(br.readLine());

            int[][] dp = new int[floor+1][room];

            for(int j = 0; j < room; j++) {
                dp[0][j] = j+1;
            }

            for(int j = 1; j < floor+1; j++) {
                dp[j][0] = 1;
            }

            for(int j = 1; j < floor+1; j++) {
                for(int k = 1; k < room; k++) {
                    dp[j][k] = dp[j - 1][k] + dp[j][k - 1];
                }
            }

            System.out.println(dp[floor][room-1]);
        }
    }
}
