import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N =  Integer.parseInt(st.nextToken());
        int K =  Integer.parseInt(st.nextToken());

        int numerator = 1;
        int denominator = 1;

        for(int i = 1; i <= K; i++) {
            numerator *= N-i+1;
            denominator *= K-i+1;
        }

        System.out.println(numerator/denominator);
    }
}