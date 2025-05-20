import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int[] dp = new int[N+1];
        int len = 1;
        dp[0] = 0;
        dp[1] = arr[1];

        for (int i = 2; i <= N; i++) {
            for(int j = 1; j <= i; j++) {
               if(dp[j] >= arr[i]) {
                   if (j > len) {
                       len = j;
                   }
                   dp[j] = arr[i];
                   break;
               } else {
                   if(dp[j] == 0) {
                       if (j > len) {
                           len = j;
                       }
                       dp[j] = arr[i];
                       break;
                   }
               }
            }
        }

        System.out.println(len);
    }
}




