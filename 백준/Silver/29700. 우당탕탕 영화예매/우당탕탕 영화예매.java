import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];

        int result = 0;

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }

            for(int j = 0; j < M-K+1; j++) {
                boolean flag = false;
                for(int k = j; k < j+K; k++) {
                    if (arr[k] != 0) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}