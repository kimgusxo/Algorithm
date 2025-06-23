import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    static Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long Q = Long.parseLong(st.nextToken());

        System.out.println(recursive(N, P, Q));
    }

    public static long recursive(long N, long P, long Q) {
        if (N == 0) return 1;

        if(memo.containsKey(N)) {
            return memo.get(N);
        }

        long result = recursive(N/P, P, Q) + recursive(N/Q, P, Q);
        memo.put(N, result);
        return result;
    }
}