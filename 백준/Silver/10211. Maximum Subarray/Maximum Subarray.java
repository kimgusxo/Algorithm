import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0] = 0;
            for(int ii = 1; ii <= N; ii++) {
                arr[ii] = arr[ii-1] + Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;
            for(int ii = 0; ii <= N; ii++) {
                for(int iii = ii+1; iii <= N; iii++) {
                    int val = arr[iii] - arr[ii];

                    if(val > max) {
                        max = val;
                    }
                }
            }

            System.out.println(max);
        }
    }
}

