import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int divide = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int val = 1;

        while(true) {
            if(Math.pow(2, val) < N) {
                val++;
            } else {
                break;
            }
        }

        int result = (int) Math.pow(2, val);

        for(int i = 0; i <= val; i++) {
            if((N & (1 << i)) != 0) {
                System.out.println(result + " " + (val-i));
                break;
            }
        }

    }
}