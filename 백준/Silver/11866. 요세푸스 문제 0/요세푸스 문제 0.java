import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();

        int cnt = 1;
        while(queue.size() > 1) {
            if(cnt%K == 0) {
                sb.append(queue.poll()).append(", ");
            } else {
                queue.add(queue.poll());
            }

            cnt++;
        }

        sb.append(queue.poll());

        System.out.println("<" + sb + ">");
    }
}