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

        int[] arr = new int[M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[j] += Integer.parseInt(st.nextToken());
            }
        }

        int row = Integer.parseInt(br.readLine());
        int max = 0;

        for(int i = 0; i < arr.length-row+1; i++) {
            int sum = 0;
            for(int j = i; j < i+row; j++) {
                sum += arr[j];
            }

            if(sum > max) {
                max = sum;
            }
        }

        System.out.println(max);
    }
}