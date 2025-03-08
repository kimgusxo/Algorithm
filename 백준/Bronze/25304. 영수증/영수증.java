import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bill = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int quantity = Integer.parseInt(st.nextToken());

            result += price * quantity;
        }

        if(result == bill) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}