import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int M = Integer.parseInt(br.readLine());
        for(int i = 1; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        while(true) {
            if(pq.isEmpty()) break;

            int x = pq.poll();
            if(M <= x) {
                M++;
                cnt++;
                x--;
                pq.add(x);
            } else {
                break;
            }
        }

        System.out.println(cnt);
    }
}