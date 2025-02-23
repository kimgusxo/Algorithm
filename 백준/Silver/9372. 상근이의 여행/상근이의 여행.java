import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

            for(int j = 0; j <= N; j++) {
                arr.add(new ArrayList<>());
            }

            for(int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());

                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                arr.get(n1).add(n2);
                arr.get(n2).add(n1);
            }

            boolean[] flag = new boolean[N+1];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            int result = 0;

            while(!queue.isEmpty()) {
                int cur = queue.poll();
                flag[cur] = true;

                for(Integer a : arr.get(cur)) {
                    if(!flag[a]) {
                        queue.offer(a);
                        flag[a] = true;
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }
}
