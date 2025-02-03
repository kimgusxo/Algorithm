import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer num1 = Integer.parseInt(st.nextToken());
        Integer num2 = Integer.parseInt(st.nextToken());

        int min = 0;

        int i = 1;

        while(i <= num1*num2) {

            if(num1%i == 0 && num2%i == 0) {
                min = i;
            }

            i++;
        }

        System.out.println(min);
        System.out.println(min*(num1/min)*(num2/min));
    }
}
