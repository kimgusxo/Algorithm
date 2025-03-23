import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            pq1.offer(num1);
            pq2.offer(num2);
        }

        ArrayList<Integer> arr = new ArrayList<>();

        int result1 = (N/6*pq1.peek() + N%6*pq2.peek());
        int result2 = (N/6+1)*pq1.peek();
        int result3 = N*pq2.peek();

        arr.add(result1);
        arr.add(result2);
        arr.add(result3);

        Collections.sort(arr);

        System.out.println(arr.get(0));
    }
}