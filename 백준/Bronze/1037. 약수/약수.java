import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int max = 0;
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int M = Integer.parseInt(st.nextToken());

            if(M > max) {
                max = M;
            }

            if(min > M) {
                min = M;
            }
        }

        System.out.println(max*min);

    }
}


