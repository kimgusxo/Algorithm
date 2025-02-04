import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer c = Integer.parseInt(br.readLine());

        for(int i = 0; i < c; i++) {
            Integer num = Integer.parseInt(br.readLine());

            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            q.add(2);
            q.add(3);

            int result = 0;

            while(!q.isEmpty()) {
                int el = q.poll();
                if(el == num) {
                    result++;
                }
                for (int j = 1; j <= 3; j++) {
                    int next = el + j;
                    if(next <= num) {
                        q.add(next);
                    }
                }
            }

            System.out.println(result);
        }
    }
}
