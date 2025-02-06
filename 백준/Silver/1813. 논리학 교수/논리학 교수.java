import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[51];

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            arr[Integer.parseInt(st.nextToken())]++;
        }

        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == i) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);

    }
}