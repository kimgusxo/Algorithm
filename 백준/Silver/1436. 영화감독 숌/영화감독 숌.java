import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int result = 666;

        while(cnt != N) {
            if(String.valueOf(result).contains("666")) {
                cnt++;
            }
            result++;
        }

        System.out.println(result-1);

    }
}

