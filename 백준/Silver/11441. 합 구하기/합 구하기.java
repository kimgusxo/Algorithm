import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefix = new int[N];
        prefix[0] = arr[0];
        for(int i = 1; i < N; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int sum = 0;

            if(l == 1) {
                sum = prefix[r-1];
            } else {
                sum = prefix[r-1]-prefix[l-2];
            }

            System.out.println(sum);
        }

    }
}

