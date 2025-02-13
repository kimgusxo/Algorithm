import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int point = 0;
        int cnt = 0;

        for(int i = arr.length-1; i >= 0; i--) {
            if(arr[i] > point) {
                point = arr[i];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}