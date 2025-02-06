import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        int val = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] sum = new int[cnt+1];
        sum[0] = 0;
        for (int i = 1; i <= cnt; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for(int i = 0; i < cnt; i++) {
            for(int j = i+1; j <= cnt; j++) {
                if(val == sum[j]-sum[i]) {
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}