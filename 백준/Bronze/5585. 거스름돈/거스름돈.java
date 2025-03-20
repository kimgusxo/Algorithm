import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int value = 1000 - Integer.parseInt(br.readLine());

        value = calc(500, value);
        value = calc(100, value);
        value = calc(50, value);
        value = calc(10, value);
        value = calc(5, value);
        value = calc(1, value);

        System.out.println(cnt);
    }

    public static int calc(int charge, int value) {
        while(value >= charge) {
            value -= charge;
            cnt++;
        }

        return value;
    }
}

