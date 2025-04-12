import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        long odds = Y*100/X;

        if (odds >= 99) {
            System.out.println(-1);
            return;
        }

        long min = 1;
        long max = X;

        while(min < max) {
            long mid = (min+max)/2;
            long newX = X+mid;
            long newY = Y+mid;

            long newOdds = newY*100/newX;

            if(odds < newOdds) {
                max = mid;
            } else {
                min = mid+1;
            }
        }

        System.out.println(min);
    }
}
