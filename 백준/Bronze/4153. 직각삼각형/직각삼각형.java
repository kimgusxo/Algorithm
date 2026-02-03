import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());

            if(n1 == 0 && n2 == 0 && n3 == 0) break;

            List<Integer> list = new ArrayList<>(List.of(n1, n2, n3));
            Collections.sort(list);

            if(Math.pow(list.get(2), 2) == Math.pow(list.get(0), 2) + Math.pow(list.get(1), 2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}