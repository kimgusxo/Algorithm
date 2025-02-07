import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int sum = 0;
        for(int i = 1; i <= N; i++) {
            backTracking(arr, 0, cnt, sum, i, S);
        }

        System.out.println(result);

    }

    public static void backTracking(int[] arr, int start, int cnt, int sum, int M, int S) {
        if(cnt == M) {
            if(sum == S) {
                result++;
            }
            return;
        }

        for(int i = start; i < arr.length; i++) {
            cnt++;
            sum += arr[i];

            backTracking(arr, i + 1, cnt, sum, M, S);

            sum -= arr[i];
            cnt--;
        }
    }
}