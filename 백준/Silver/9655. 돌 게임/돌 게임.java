import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            if(i-1 >= 0&& !dp[i-1]) {
                dp[i] = true;
            } else if (i-3 >= 0 && !dp[i-3]) {
                dp[i] = true;
            }
        }

        System.out.println(dp[N] ? "SK" : "CY");
    }
}

