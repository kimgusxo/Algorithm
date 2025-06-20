import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while(!queue.isEmpty()) {
            int el = queue.poll();
            list.add(el);

            if(queue.isEmpty()) break;

            int el2 = queue.poll();
            queue.add(el2);
        }

        for(int n : list) {
            System.out.print(n + " ");
        }

    }
}