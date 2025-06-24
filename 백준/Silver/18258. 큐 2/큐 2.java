import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();

            switch(cmd) {
                case "push":
                    int el = Integer.parseInt(st.nextToken());
                    deque.addLast(el);
                    break;
                case "pop":
                    if(deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.pop()+"\n");
                    }
                    break;
                case "size":
                    bw.write(deque.size()+"\n");
                    break;
                case "empty":
                    if(deque.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if(deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.peekFirst()+"\n");
                    }
                    break;
                case "back":
                    if(deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.peekLast()+"\n");
                    }
                    break;
            }
        }
        bw.flush();
    }
}