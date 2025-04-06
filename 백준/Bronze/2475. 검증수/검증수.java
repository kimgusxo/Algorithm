import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;

        while(st.hasMoreTokens()) {
            int N = Integer.parseInt(st.nextToken());

            result += (int) Math.pow(N, 2);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(result%10));
        bw.flush();
    }
}

