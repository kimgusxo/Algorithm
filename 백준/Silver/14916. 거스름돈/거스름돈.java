import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pay = Integer.parseInt(br.readLine());

        int range = pay/5;

        boolean flag = false;
        int five = 0;
        int two = 0;

        for(int i = range; i >= 0; i--) {
            int serve = pay-(5*i);

            if(serve%2 == 0) {
                five = i;
                two = serve/2;
                flag = true;
                break;
            }
        }

        if(flag) {
            System.out.println(five+two);
        } else {
            System.out.println(-1);
        }
    }
}