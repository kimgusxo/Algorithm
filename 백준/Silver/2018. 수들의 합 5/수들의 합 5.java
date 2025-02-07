import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n/2+2];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }

        int left = 1;
        int right = 2;
        int result = 1;

        if(n == 1) {
            System.out.println(result);
        } else {
            while(left < right) {
                int val = 0;

                for(int i = left; i <= right; i++) {
                    val += arr[i];
                }

                if(val < n) {
                    right++;
                } else if(val > n) {
                    left++;
                } else {
                    result++;
                    left++;
                }
            }

            System.out.println(result);
        }
    }
}