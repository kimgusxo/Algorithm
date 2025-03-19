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

        int[] arr = new int[N];

        long result = 0;
        long max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            result += arr[i];
        }

        max = result;

        for(int i = M; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            result += arr[i];
            result -= arr[i-M];

            if(max < result) {
                max = result;
            }
        }

        System.out.println(max);

    }
}

