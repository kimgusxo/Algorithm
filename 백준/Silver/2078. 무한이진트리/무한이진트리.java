import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int right = 0;
        int left = 0;

        while(true) {
            if(N < M) {
                M -= N;
                right++;
            } else {
                N -=  M;
                left++;
            }

            if(N == 1 && M == 1) break;
        }

        System.out.println(left + " " + right);
    }
}