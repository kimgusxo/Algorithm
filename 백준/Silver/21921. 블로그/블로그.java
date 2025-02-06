import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int date = Integer.parseInt(st.nextToken());
        int period = Integer.parseInt(st.nextToken());

        int[] sum = new int[date+1];

        st = new StringTokenizer(br.readLine());
        sum[0] = 0;
        for(int i = 1; i <= date; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(sum[period]-sum[0]);
        for(int i = 1; i <= date-period; i++) {
            int max = sum[period+i]-sum[i];
            if(max > arr.get(0)) {
                arr.clear();
                arr.add(max);
            } else if(max == arr.get(0)) {
                arr.add(max);
            }
        }

        if(arr.get(0) == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(arr.get(0));
            System.out.println(arr.size());
        }
    }
}