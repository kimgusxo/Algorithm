import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "1":
                    int num = Integer.parseInt(st.nextToken());
                    deque.addFirst(num);
                    break;
                case "2":
                    num = Integer.parseInt(st.nextToken());
                    deque.addLast(num);
                    break;
                case "3":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.removeFirst());
                    }
                    break;
                case "4":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.removeLast());
                    }
                    break;
                case "5":
                    System.out.println(deque.size());
                    break;
                case "6":
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
                case "7":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.peekFirst());
                    }
                    break;
                case "8":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.peekLast());
                    }
                    break;
            }
        }
    }
}
