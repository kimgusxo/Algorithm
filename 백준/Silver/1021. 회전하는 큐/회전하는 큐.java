import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        int[] targets = new int[M];

        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        int op = 0;

        for(int target : targets) {
            int index = 0;

            for(int el : deque) {
                if(el == target) {
                    break;
                }
                index++;
            }

            int size = deque.size();

            if(index <= size/2) {
                for(int i = 0; i < index; i++) {
                    deque.addLast(deque.removeFirst());
                    op++;
                }
            } else {
                for(int i = 0; i < size-index; i++) {
                    deque.addFirst(deque.removeLast());
                    op++;
                }
            }
            deque.removeFirst();
        }

        System.out.println(op);

    }
}
