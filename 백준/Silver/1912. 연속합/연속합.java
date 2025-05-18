import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];

        dp[0] = num[0];
        int max = dp[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i-1] + num[i], num[i]);
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}




