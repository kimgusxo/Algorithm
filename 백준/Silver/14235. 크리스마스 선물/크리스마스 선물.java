import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int el = Integer.parseInt(st.nextToken());
            if(el == 0) {
                if(queue.isEmpty()) {
                    bw.write(-1 +"\n");
                } else {
                    bw.write(queue.poll()+"\n");
                }
            } else {
                while(st.hasMoreTokens()) {
                    queue.add(Integer.parseInt(st.nextToken()));
                }
            }
        }

        bw.flush();
    }
}