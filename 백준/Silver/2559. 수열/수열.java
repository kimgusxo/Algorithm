import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> prefix = new ArrayList<>();
        int[] arr = new int[N];
        int init = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            init += arr[i];
        }

        prefix.add(init);

        int cnt = 0;
        for (int i = K; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefix.add(prefix.get(cnt) - arr[cnt] + arr[i]);
            cnt++;
        }

        prefix.sort(Collections.reverseOrder());

        System.out.println(prefix.get(0));
    }
}

