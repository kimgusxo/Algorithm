import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];
        int result = 0;

        arr[0] = Integer.parseInt(br.readLine());
        for(int i = 1; i < 10; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(br.readLine());

            if(arr[i] >= 100) {
                int num1 = 100-arr[i-1];
                int num2 = arr[i]-100;

                if(num1 >= num2) {
                    result = arr[i];
                } else {
                    result = arr[i-1];
                }

                break;
            }
        }

        if(result == 0) {
            result = arr[9];
        }
        System.out.println(result);
    }
}

