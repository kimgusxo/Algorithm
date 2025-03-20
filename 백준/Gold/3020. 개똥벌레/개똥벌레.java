import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] freq1 = new int[H];
        int[] freq2 = new int[H];

        int[] prefix = new int[H];

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(i % 2 == 0) {
                freq1[num-1]++;
            } else {
                freq2[num-1]++;
            }
        }

        int cnt = 1;
        prefix[0] = N/2;
        int min = N/2;
        for(int i = 1; i < H; i++) {
            prefix[i] = prefix[i-1]-freq1[i-1]+freq2[H-i-1];
            if(min > prefix[i]) {
                cnt = 1;
                min = prefix[i];
            } else if(min == prefix[i]) {
                cnt++;
            }
        }

        System.out.println(min + " " + cnt);
    }
}