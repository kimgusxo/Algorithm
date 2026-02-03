import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int min = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int el =  Integer.parseInt(st.nextToken());
            list.add(el);
        }

        Collections.sort(list);

        for(int i = 0; i < N; i++) {
            if(min >= list.get(i)) {
                min += list.get(i);
            } else {
                break;
            }
        }

        System.out.println(min);
    }
}