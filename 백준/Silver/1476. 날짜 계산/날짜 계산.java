import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static PriorityQueue<Integer> results = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int earth = 1;
        int solar = 1;
        int moon = 1;

        int year = 1;

        while(true) {
            if(earth == E && solar == S && moon == M) {
                break;
            }

            earth++;
            solar++;
            moon++;

            year++;

            if(earth > 15) {
                earth = 1;
            }

            if(solar > 28) {
                solar = 1;
            }

            if(moon > 19) {
                moon = 1;
            }
        }

        System.out.println(year);
    }
}
