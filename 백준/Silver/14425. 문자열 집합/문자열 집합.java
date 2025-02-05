import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<String> arr = new ArrayList<>();
        ArrayList<String> check = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            arr.add(br.readLine());
        }

        for(int i = 0; i < m; i++) {
            check.add(br.readLine());
        }

        int result = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr.get(i).equals(check.get(j))) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
